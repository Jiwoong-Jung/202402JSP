<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

String memberno = request.getParameter("memberno");

String sql = "delete from member where memberno=?";
PreparedStatement pstmt = conn.prepareStatement(sql);

pstmt.setString(1, memberno);

int res = pstmt.executeUpdate();
response.sendRedirect("list.jsp");
%>