<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form name="join" class="form-horizontal" method="post"
			onsubmit="return checkForm()">
			<input type="hidden" name="GRADE" value="SILVER">
			<div class="mb-3">
				<label class="form-label ">아이디</label>
				<div class="form-control">
					<input name="MEMBER_ID" type="text" class="form-control"
						placeholder="id" required="required">
				</div>
			</div>
			<div class="mb-3">
				<label class="form-label">비밀번호</label>
				<div class="form-control">
					<input name="PASSWORD" type="password" class="form-control"
						placeholder="password" required="required">
				</div>
			</div>
			<div class="mb-3">
				<label class="form-label">이름</label>
				<div class="form-control">
					<input name="NAME" type="text" class="form-control"
						placeholder="name" required="required">
				</div>
			</div>

			<div class="mb-3">
				<label class="form-label">전화번호</label>
				<div class="form-control">
					<input name="PHONE" type="text" class="form-control"
						placeholder="phonenumber" required="required">
				</div>
			</div>

			<div class="mb-3">
				<label class="form-label">카드번호</label>
				<div class="form-control">
					<input name="CARD" type="text" class="form-control"
						placeholder="address">
				</div>
			</div>

			<div class="form-group  row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" class="btn btn-primary " value="등록 ">
					<input type="reset" class="btn btn-primary " value="취소 "
						onclick="reset()">
				</div>
			</div>
		</form>
	</div>
</body>
</html>