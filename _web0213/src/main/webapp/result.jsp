<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//Cookies cookies = new Cookies(request);
String remember = request.getParameter("remember");
String email = request.getParameter("email");
if (remember != null && remember.equals("on")) {
    response.addCookie(
    	Cookies.createCookie("email", email, "/", 60*60*24*30)
    );
} else {
	response.addCookie(
		Cookies.createCookie("email", "", "/", 0)
	);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
시작 홈페이지
</body>
</html>