<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");

    if (id.equals("admin") && pw.equals("1234")) {
        Cookie cookie = new Cookie("userId", id);
        cookie.setMaxAge(-1);         // 웹 브라우저가 닫힐 때 쿠키 만료됨
        response.addCookie(cookie);
        
        response.sendRedirect("8-1.jsp");   // 로그인 메인 화면으로 돌아감
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>