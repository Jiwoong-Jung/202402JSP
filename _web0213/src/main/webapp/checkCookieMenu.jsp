<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookies cookies = new Cookies(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="result.jsp">
email: <input type="text" name="email" 
                      value="<%=cookies.getValue("email") %>"/>
remember me: <input type="checkbox" name="remember" checked />
<input type="submit" />
</form>
</body>
</html>