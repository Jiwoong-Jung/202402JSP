<%@page import="mvjsp.board.model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mvjsp.board.dao.MemberDao"%>
<%@page import="mvjsp.jdbc.connection.ConnectionProvider"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Connection conn = ConnectionProvider.getConnection();
MemberDao dao = MemberDao.getInstance();
ArrayList<Member> list = dao.selectAll(conn);
request.setAttribute("list", list);
%>
<jsp:forward page="list_view.jsp" />


