<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = "";
Cookie[] cookies = request.getCookies();           
if (cookies != null) {
    for(Cookie cookie : cookies) {           
        if (cookie.getName().equals("email")) {
            email = cookie.getValue();
            break;
        }
    }
}

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="cookieSave.jsp">
        이메일:<input type="text" name="email" value="<%=email %>" />
        기억하기:<input type="checkbox" checked name="ck"/>
        <input type="submit" value="로그인" />
    </form>
</body>
</html>