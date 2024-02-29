
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String mno = request.getParameter("memberno");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
String sql = "select * from member where memberno = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, Integer.parseInt(mno)); 
ResultSet rs = pstmt.executeQuery();
int memberno = 0;
String id = null;
String email = null;
String name = null;
if (rs.next()) {
	memberno = rs.getInt("memberno");
	id = rs.getString("id");
	email = rs.getString("email");
	name = rs.getString("name");
}
%>
<jsp:forward page="updateForm_view.jsp"/>






