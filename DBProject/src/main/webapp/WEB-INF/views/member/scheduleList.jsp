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
				<th scope="col" style="text-align: center;">#</th>
				<th scope="col" style="text-align: center;">역번호</th>
				<th scope="col" style="text-align: center;">열차번호</th>
				<th scope="col" style="text-align: center;">방향</th>
				<th scope="col" style="text-align: center;">시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lists}" var="data" varStatus="status">
				<tr>
					<td style="vertical-align: middle; text-align: center;">${status.count}</td>
					<td style="vertical-align: middle; text-align: center;">${data.STATION_ID}</td>
					<td style="vertical-align: middle; text-align: center;">${data.TRAIN_ID}</td>
					<td style="vertical-align: middle; text-align: center;">${data.DIRECTION}</td>
					<td style="vertical-align: middle; text-align: center;">${data.TIME}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2 align="center">시간표 등록</h2>
	<form action="/admin/addSchedule" method="post">
		<select name="STATION_ID" class="form-select" aria-label="기차역선택">
			<option value="1">서울</option>
			<option value="2">천안</option>
			<option value="3">대전</option>
			<option value="4">대구</option>
			<option value="5">부산</option>
		</select> <input class="form-control" class="form-select" type="text"
			name="TRAIN_ID" placeholder="열차번호" aria-label="default input example">
		<select name="DIRECTION" aria-label="방향선택">
			<option value="상행">상행</option>
			<option value="하행">하행</option>
		</select> <br> <select name="TIME" aria-label="시간선택" class="selectpicker">
			<option value="9:00">9:00</option>
			<option value="10:00">10:00</option>
			<option value="11:00">11:00</option>
			<option value="12:00">12:00</option>
			<option value="1:00">1:00</option>
		</select> 
		<br>
		<input type="submit" class="btn btn-outline-secondary" value="등록">
		<a href="/admin" class="btn btn-outline-success">돌아가기</a>
	</form>
</body>
</html>