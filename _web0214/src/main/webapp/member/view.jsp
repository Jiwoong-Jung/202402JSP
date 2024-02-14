<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>

<%
    // 지정된 글 번호 얻기
    int num = Integer.parseInt(request.getParameter("num"));    
	String memberId = (String)session.getAttribute("MEMBERID");
	if (memberId == null) {
		response.sendRedirect("sessionLoginForm.jsp");
	}
	BoardDao dao = BoardDao.getInstance();
	Board board = dao.selectOne(num, true);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>
</head>
<body>

<table>
    <tr>
        <th>제목</th>
        <td><%=board.getTitle()%></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=board.getWriter()%></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=board.getRegtime()%></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=board.getHits()%></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=board.getContent()%></td>
    </tr>
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<input type="button" value="수정"
       onclick="location.href='write.jsp?num=<%=num%>'">
<input type="button" value="삭제"
       onclick="location.href='delete.jsp?num=<%=num%>'">

</body>
</html>
