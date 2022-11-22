<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>예약실패</title>
</head>
<body>
	<h1>이미 예약된 자리입니다.</h1>
	<%
	String member_id = request.getParameter("MEMBER_ID");
	%>
	<c:url value="/reserve" var="url">
		<c:param name="MEMBER_ID" value="<%=member_id%>"></c:param>
	</c:url>
	<a href="${url} " class="btn btn-outline-success">돌아가기</a>

</body>
</html>