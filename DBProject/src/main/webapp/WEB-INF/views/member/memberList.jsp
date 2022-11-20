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
	<jsp:include page="../menu.jsp"></jsp:include>
	<table class="table font-noto">
		<thead>
			<tr class="table-light">
				<th scope="col" style="text-align: center;">#</th>
				<th scope="col" style="text-align: center;">id</th>
				<th scope="col" style="text-align: center;">이름</th>
				<th scope="col" style="text-align: center;">전화번호</th>
				<th scope="col" style="text-align: center;">등급</th>
				<th scope="col" style="text-align: center;">카드번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${memberlists}" var="data" varStatus="status">
				<tr>
					<td style="vertical-align: middle; text-align: center;">${status.count}</td>
					<td style="vertical-align: middle; text-align: center;">${data.MEMBER_ID}</td>
					<td style="vertical-align: middle; text-align: center;">${data.NAME}</td>
					<td style="vertical-align: middle; text-align: center;">${data.PHONE}</td>
					<td style="vertical-align: middle; text-align: center;">
						<form action="/memberGradeUpdate" method="post">
							<select name="GRADE">
								<option selected>${data.GRADE}</option>
								<option>SILVER</option>
								<option>GOLD</option>
								<option>VIP</option>
							</select> <input type="hidden" name="MEMBER_ID" value="${data.MEMBER_ID}">
							<input type="submit" class="btn btn-outline-secondary" value="수정">
						</form>
					</td>
					<td style="vertical-align: middle; text-align: center;">${data.CARD}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/" class="btn btn-outline-success">돌아가기</a>
</body>
</html>