<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%
// 지정된 글 번호 얻기
int num = Integer.parseInt(request.getParameter("num"));

String memberId = (String) session.getAttribute("MEMBERID");
if (memberId == null) {
	response.sendRedirect("sessionLoginForm.jsp");
}
BoardDao dao = BoardDao.getInstance();
dao.delete(num);

// 목록보기 화면으로 돌아감
response.sendRedirect("list.jsp");
%>