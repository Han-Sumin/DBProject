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
				<th scope="col" style="text-align: center;">열차등급</th>
				<th scope="col" style="text-align: center;">방향</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lists}" var="data" varStatus="status">
				<tr>
					<td style="vertical-align: middle; text-align: center;">${status.count}</td>
					<td style="vertical-align: middle; text-align: center;">${data.TRAIN_NAME}</td>
					<td style="vertical-align: middle; text-align: center;">${data.DIRECTION}</td>


				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%
	String member_id = request.getParameter("MEMBER_ID");
	%>
	<c:url value="/reserve" var="url">
		<c:param name="MEMBER_ID" value="<%=member_id%>"></c:param>
	</c:url>
	<a href="${url} " class="btn btn-outline-success">돌아가기</a>
</body>
</html>