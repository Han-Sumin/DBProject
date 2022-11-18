<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="./menu.jsp"></jsp:include>
	<h1 align="center">철도 예약 시스템에 오신 것을 환영합니다.</h1>
	<br>
	<br>
	<br>
	<div align="center">
		<a class="btn btn-outline-primary btn-sm" href="/login">로그인하기</a> <a
			class="btn btn-outline-primary btn-sm" href="/join">회원가입하기</a>
	</div>
	<br>
	<br>
	<br>
	<hr>
	<P>현재 시각 ${serverTime}.</P>
</body>
</html>