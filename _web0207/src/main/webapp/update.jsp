<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
request.setCharacterEncoding("utf-8");
//String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";
Connection conn = DriverManager.getConnection(url, "scott", "tiger");
String sql = "update score set name=?, kor=?, eng=?, math=? where num=?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(5, request.getParameter("num"));
pstmt.setString(1, request.getParameter("name"));
pstmt.setString(2, request.getParameter("kor"));
pstmt.setString(3, request.getParameter("eng"));
pstmt.setString(4, request.getParameter("math"));
int res = pstmt.executeUpdate();
response.sendRedirect("index.jsp");
%>
</body>
</html>

