<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = request.getParameter("email");
String ck = request.getParameter("ck");

if (ck != null && ck.equals("on")) { // 쿠키 생성
	Cookie cookie = new Cookie("email", email);
	cookie.setMaxAge(60);
	response.addCookie(cookie);
} else { // 쿠키 삭제
	Cookie cookie = new Cookie("email", null);
	cookie.setMaxAge(0);
	response.addCookie(cookie);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>