<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>예약하기</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<%
	String member_id = request.getParameter("MEMBER_ID");
	%>
	<c:url value="/mypage" var="url">
	<c:param name="MEMBER_ID" value="<%=member_id%>"></c:param>
	</c:url>
	<a href="${url}">내 정보</a>
	<h1>열차 운행표</h1>

	<h1 align="center">예매하기</h1>
	<h2 align="center">출발역과 도착역을 선택하여 주세요.</h2>
	<form action="/reserve/reservedstatus" method="post">
		<input type="hidden" name="MEMBER_ID" value="<%=member_id%>">
		<select name="START_STATION" aria-label="기차역선택" class="selectpicker">
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
		</select> <select name="PAY_METHOD" class="form-select" aria-label="결제방법선택">
			<option selected>결제방법</option>
			<option value="카드">카드</option>
			<option value="계좌이체">계좌이체</option>
		</select> <select name="TRAIN_ID" class="form-select" aria-label="열차등급선택">
			<option selected>열차등급</option>
			<option value="1234">무궁화호</option>
			<option value="1235">새마을호</option>
		</select>


		<button class="btn btn-outline-success" type="submit">등록</button>
	</form>
</body>
</html>