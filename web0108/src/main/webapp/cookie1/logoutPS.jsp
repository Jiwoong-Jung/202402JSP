<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    Cookie cookie = new Cookie("userId", null);
    cookie.setMaxAge(0);           
    response.addCookie(cookie);
        
    response.sendRedirect("loginCK.jsp?logout=1");   // 로그인 메인 화면으로 돌아감
%>