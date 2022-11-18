<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
</head>
<body>
	<ul class="nav font-noto border-bottom">
		<c:if test="${member != null}">
			<li class="nav-item"><a
				class="nav-link link-light pl-5 text-dark">${member.name}님,
					안녕하세요.</a></li>
			<li class="nav-item"><a href="/logout"
				class="nav-link pl-2 text-dark">로그아웃</a></li>
		</c:if>
	</ul>
	<h1 align="center">예매하기</h1>
	<h2 align="center">출발역과 도착역을 선택하여 주세요.</h2>
	<form action="/reserveseat">
			<input type="hidden" name="member_id" value="hi">
			<input type="hidden" name="" value="hi">
		<select name="start_station" aria-label="기차역선택">
			<option selected>출발역</option>
			<option value="1">서울</option>
			<option value="2">천안</option>
			<option value="3">대전</option>
			<option value="4">대구</option>
			<option value="5">부산</option>
		</select> <select name="arrival_station" aria-label="기차역선택">
			<option selected>출발역</option>
			<option value="1">서울</option>
			<option value="2">천안</option>
			<option value="3">대전</option>
			<option value="4">대구</option>
			<option value="5">부산</option>
		</select>

		<button class="btn btn-outline-success" type="submit">등록</button>
	</form>
</body>
</html>