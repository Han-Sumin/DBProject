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
	String PRICE = request.getParameter("PRICE");
	%>
	<h1 align="center"></h1>
	<c:forEach items="${lists}" var="data">
		<h3 align="center">예약해주셔서 감사합니다. 무궁화호는 한 역당 1,000이고 새마을호는 한 역당 1,500원입니다.</h3>
		<table class="table font-noto">
			<thead>
				<tr class="table-light">
					<th scope="col" style="text-align: center;">예약일</th>
					<th scope="col" style="text-align: center;">가격</th>
					<th scope="col" style="text-align: center;">결제방법</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lists}" var="data" varStatus="status">
					<tr>
						<td style="vertical-align: middle; text-align: center;">${data.RESERVE_DATE}</td>
						<td style="vertical-align: middle; text-align: center;"><%=PRICE%></td>
						<td style="vertical-align: middle; text-align: center;">${data.PAY_METHOD}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:forEach>
	<a href="/" class="btn btn-outline-success">돌아가기</a>
</body>
</html>