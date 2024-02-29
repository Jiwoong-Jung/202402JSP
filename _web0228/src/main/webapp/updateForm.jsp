<%@page import="mvjsp.board.dao.MemberDao"%>
<%@page import="mvjsp.jdbc.connection.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String mno = request.getParameter("memberno");
Connection conn = ConnectionProvider.getConnection();
MemberDao dao = MemberDao.getInstance();
%>
<jsp:forward page="updateForm_view.jsp"/>






