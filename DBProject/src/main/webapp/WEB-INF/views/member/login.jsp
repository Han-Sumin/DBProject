<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>
	<div class="container">
		<section id="content">
			<form name="login" class="form-horizontal" method="post">
				<div class="mb-3">
					<label for="member_id">아이디</label> <input type="text" id="member_id"
						name="member_id" required="required" class="form-control"/>
				</div>

				<div class="mb-3">
					<label for="password">패스워드</label> <input type="password"
						id="password" name="password" required="required" class="form-control"/>
				</div>
				<div class="form-group  row">
					<div class="col-sm-offset-2 col-sm-10 ">
						<input type="submit" class="btn btn-primary " value="로그인">
					</div>
				</div>
				<c:if test="${msg == false}">
					<p style="color: #f00;">로그인에 실패했습니다.</p>
				</c:if>
			</form>
		</section>
	</div>
</body>
</html>