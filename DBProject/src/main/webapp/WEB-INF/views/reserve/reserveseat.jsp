<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<h1 align="center">좌석을 선택해주세요</h1>
	<%
	String reserve_id = request.getParameter("RESERVE_ID");
	String train_id = request.getParameter("TRAIN_ID");
	String train_num = request.getParameter("TRAIN_NUM");

	String member_id = request.getParameter("MEMBER_ID");

	int reserveId = Integer.parseInt(reserve_id);
	%>

<div align="center">
	<a
		href="/reserve/reserveseat?RESERVE_ID=<%=reserve_id%>&&TRAIN_ID=<%=train_id%>&&TRAIN_NUM=1&&MEMBER_ID=<%=member_id%>">1호차</a>
	<a
		href="/reserve/reserveseat?RESERVE_ID=<%=reserve_id%>&&TRAIN_ID=<%=train_id%>&&TRAIN_NUM=2&&MEMBER_ID=<%=member_id%>">2호차</a>
</div>
<br>
<br>
<br><div align="center">
	<form action="/reserve/reserveseat" method="POST">
		<input type="hidden" name="RESERVE_ID" value="<%=reserveId%>">
		<input type="hidden" name="TRAIN_NUM" value="<%=train_num%>">
		<input type="hidden" name="TRAIN_ID" value="<%=train_id%>"> <input
			type="hidden" name="MEMBER_ID" value="<%=member_id%>">
		<c:forEach items="${lists}" var="data">
			<div class="d-grid gap-2 col-6 mx-auto">
				<input class="btn-check" type="checkbox" name="SEAT_NUM"
					value="${data.SEAT_NUM}" id="btn-check" autocomplete="off">
				<label class="btn btn-primary" for="btn-check">${data.SEAT_NUM}</label>
			</div>
		</c:forEach>
		<br>
		<button type="submit" class="btn btn-outline-primary" >예매</button>
	</form>
	</div>
</body>
</html>