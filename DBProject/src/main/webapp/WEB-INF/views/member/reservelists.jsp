<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<%
	String member_id = request.getParameter("MEMBER_ID");
	%>
	<h4 align="center">역번호는 1 : 서울, 2 : 천안, 3 : 대전, 4 : 대구, 5 : 부산입니다.</h4>
	<table class="table font-noto">
		<thead>
			<tr class="table-light">
				<th scope="col" style="text-align: center;">예약번호</th>
				<th scope="col" style="text-align: center;">출발역</th>
				<th scope="col" style="text-align: center;">도착역</th>
				<th scope="col" style="text-align: center;">예약날짜</th>
				<th scope="col" style="text-align: center;">결제방법</th>
				<th scope="col" style="text-align: center;">취소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lists}" var="data" varStatus="status">
				<tr>
					<td style="vertical-align: middle; text-align: center;">${data.RESERVE_ID}</td>
					<td style="vertical-align: middle; text-align: center;">${data.START_STATION}</td>
					<td style="vertical-align: middle; text-align: center;">${data.ARRIVAL_STATION}</td>
					<td style="vertical-align: middle; text-align: center;">${data.RESERVE_DATE}</td>
					<td style="vertical-align: middle; text-align: center;">${data.PAY_METHOD}</td>
					<td style="vertical-align: middle; text-align: center;">
						<form action="/deletereserve" method="post">
							<input type="hidden" name="MEMBER_ID" value="${data.MEMBER_ID}">
							<input type="hidden" name="RESERVE_ID" value="${data.RESERVE_ID}">
							<input type="submit" class="btn btn btn-danger" value="취소">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:url value="/reserve" var="url">
		<c:param name="MEMBER_ID" value="<%=member_id%>"></c:param>
	</c:url>
	<a href="${url }" class=" btn btn-outline-success">돌아가기</a>
</body>
</html>