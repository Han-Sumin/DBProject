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
	<table class="table font-noto">
		<thead>
			<tr class="table-light">
				<th scope="col" style="text-align: center;">id</th>
				<th scope="col" style="text-align: center;">이름</th>
				<th scope="col" style="text-align: center;">전화번호</th>
				<th scope="col" style="text-align: center;">등급</th>
				<th scope="col" style="text-align: center;">카드번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lists}" var="data" varStatus="status">
				<tr>
					<td style="vertical-align: middle; text-align: center;">${data.MEMBER_ID}</td>
					<td><form action="/nameUpdate" method="post">
							<input type="text" name="NAME" placeholder="${data.NAME}">
							<input type="hidden" name="MEMBER_ID" value="${data.MEMBER_ID}">
							<input type="submit" class="btn btn-outline-secondary" value="수정">
						</form></td>
					<td><form action="/phoneUpdate" method="post">
							<input type="text" name="PHONE" placeholder="${data.PHONE}">
							<input type="hidden" name="MEMBER_ID" value="${data.MEMBER_ID}">
							<input type="submit" class="btn btn-outline-secondary" value="수정">
						</form></td>
					<td style="vertical-align: middle; text-align: center;">${data.GRADE}</td>
					<td><form action="/cardUpdate" method="post">
							<input type="text" name="CARD" placeholder="${data.CARD}">
							<input type="hidden" name="MEMBER_ID" value="${data.MEMBER_ID}">
							<input type="submit" class="btn btn-outline-secondary" value="수정">
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%
	String member_id = request.getParameter("MEMBER_ID");
	%>
	<c:url value="/delete" var="url">
	<c:param name="MEMBER_ID" value="<%=member_id%>"></c:param>
	</c:url>
	<a href="${url}" class="btn btn-danger">탈퇴하기</a>
</body>
</html>