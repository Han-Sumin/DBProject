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
			<li class="nav-item"><a href="/logout"
				class="nav-link pl-2 text-dark">로그아웃</a></li>
		</c:if>
	</ul>
	<%
	String member_id = request.getParameter("MEMBER_ID");
	%>

	<h1 align="center">예매하기</h1>
	<h2 align="center">출발역과 도착역을 선택하여 주세요.</h2>
	<form action="/reserve/reservedstatus">
		<input type="hidden" name="MEMBER_ID value="<%=member_id%>"> <select
			name="START_STATION" aria-label="기차역선택" class="form-select">
			<option selected>출발역</option>
			<option value="1">서울</option>
			<option value="2">천안</option>
			<option value="3">대전</option>
			<option value="4">대구</option>
			<option value="5">부산</option>
		</select> <select name="ARRIVAL_STATION" class="form-select" aria-label="기차역선택">
			<option selected>도착역</option>
			<option value="1">서울</option>
			<option value="2">천안</option>
			<option value="3">대전</option>
			<option value="4">대구</option>
			<option value="5">부산</option>
		</select>
		
		<select name="PAY_METHOD" class="form-select" aria-label="결제방법선택">
			<option selected>결제방법</option>
			<option value="card">현금</option>
			<option value="transfer">계좌이체</option>
		</select>
		

		<button class="btn btn-outline-success" type="submit">등록</button>
	</form>
</body>
</html>