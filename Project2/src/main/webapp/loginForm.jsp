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

input {
	width: 100%;
}
#divid {
	color: red;
}
#divemail {
	color: blue;
}
#login {
	float: right;   background: red;    color: white; 
}
</style>
</head>
<body>
<div>
<form action="login.jsp" method="post">
<div id="divid">
<label>아이디</label><input type="text" name="id">
</div>
<div id="divemail">
<label>이메일</label><input type="text" name="email">
</div>
<button type="submit" id="login">로그인</button>
</form>







</div>
</body>
</html>