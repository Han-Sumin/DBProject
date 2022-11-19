<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>열차 등록</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<table class="table font-noto">
		<thead>
			<tr class="table-light">
				<th scope="col" style="text-align: center;">#</th>
				<th scope="col" style="text-align: center;">열차번호</th>
				<th scope="col" style="text-align: center;">열차등급</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lists}" var="data" varStatus="status">
				<tr>
					<td style="vertical-align: middle; text-align: center;">${status.count}</td>
					<td style="vertical-align: middle; text-align: center;">${data.TRAIN_ID}</td>
					<td style="vertical-align: middle; text-align: center;">${data.TRAIN_NAME}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2 align="center">열차 등록</h2>
	<form action="/admin/addTrain" method="post">
	<input class="form-control" type="text" name="TRAIN_ID" placeholder="열차번호" aria-label="default input example">
	<input class="form-control" type="text" name="TRAIN_NAME" placeholder="열차등급" aria-label="default input example">
	<input type="submit" class="btn btn-outline-secondary" value="등록">
	</form>
</body>
</html>