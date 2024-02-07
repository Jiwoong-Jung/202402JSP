<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if (cookies != null && cookies.length > 0) {
		for (Cookie ck : cookies) {
			out.print(ck.getName() + " = ");
			String str = URLDecoder.decode(ck.getValue(), "utf-8");
			out.print(str + "<br/>");
		}
	}
%>
</body>
</html>




