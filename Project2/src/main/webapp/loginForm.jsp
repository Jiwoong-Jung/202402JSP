<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
<style type="text/css">
div {
	margin: 10px 10px;
}
button {
	float: left;
	background: red;
	color: white;
}
input {
	width: 100%;
}
</style>
</head>
<body>
<div>
<form action="login.jsp" method="post">
<label>아이디</label><input type="text" name="id"><br>
<label>이메일</label><input type="text" name="email"><br>
<button type="submit">로그인</button>
</form>
</div>
</body>
</html>