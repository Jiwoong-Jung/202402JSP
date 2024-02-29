<%@page import="mvjsp.board.model.Member"%>
<%@page import="mvjsp.board.dao.MemberDao"%>
<%@page import="mvjsp.jdbc.connection.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String email = request.getParameter("email");
String name = request.getParameter("name");
Connection conn = ConnectionProvider.getConnection();
MemberDao dao = MemberDao.getInstance();
Member member = new Member(id, email, name);
dao.insert(conn, member);
response.sendRedirect("list.jsp");
%>
