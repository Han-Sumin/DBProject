<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
 <h2>로그인</h2>
 <form method="POST">
		<div class="mb-3">
			<label class="form-label" for="id">아이디</label> 
			<input class="form-control" type="text" name="member_id" id="member_id" />
		</div>
		<div class="mb-3">
			<label class="form-label" for="pwd">비밀번호</label> 
			<input class="form-control" type="password" name="password" id="password" />
		</div>
		<button class="btn btn-outline-primary btn-sm" type="submit">로그인</button>
		<a class="btn btn-outline-primary btn-sm" href="/join">회원가입</a>
	</form>
 </div>
</body>
</html>