<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
request.setCharacterEncoding("utf-8");
String memberno = request.getParameter("memberno");
String id = request.getParameter("id");
String email = request.getParameter("email");
String name = request.getParameter("name");
String sql = "update member set id=?, email=?, name=? where memberno=?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, id);
pstmt.setString(2, email);
pstmt.setString(3, name);
pstmt.setString(4, memberno);

int res = pstmt.executeUpdate();
response.sendRedirect("list.jsp");
%>