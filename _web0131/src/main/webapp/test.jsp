<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String str = "안녕하세요";
out.println("<h1>"+str+"</h1>");
%>
<h1><%=str %></h1>
</body>
</html>






