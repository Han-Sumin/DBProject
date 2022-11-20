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
	<h2>정말로 탈퇴를 하시겠습니까?</h2>
	<form action="/delete" method="post">
		<input type="hidden" name="MEMBER_ID" value="<%=member_id%>">
		<button type="submit" class="btn btn-danger">네</button>
	</form>
	<c:url value="/reserve" var="url">
		<c:param name="MEMBER_ID" value="<%=member_id%>"></c:param>
	</c:url>
	<a href="${url}">아니요</a>

</body>
</html>