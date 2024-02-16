<%@page import="dto.Board"%>
<%@page import="java.util.List"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%
	String memberId = (String)session.getAttribute("MEMBERID");
	if (memberId == null) {
		response.sendRedirect("sessionLoginForm.jsp");
	}
	BoardDao dao = BoardDao.getInstance();
	List<Board> list = dao.selectList();
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  </head>
  <body>
<div class="container" style="padding-top: 50px;">
<table class="table table-bordered table-hover">
    <tr>
        <th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="writer" >작성자  </th>
        <th class="regtime">작성일시</th>
        <th                >조회수  </th>
    </tr>
<%
for (Board board : list) {
%>         
        <tr>
            <td><%=board.getNum()%></td>
            <td style="text-align:left;">
                <a href="view.jsp?num=<%=board.getNum()%>">
                    <%=board.getTitle()%>
                </a>
            </td>
            <td><%=board.getWriter()%></td>
            <td><%=board.getRegtime()%></td>
            <td><%=board.getHits()%></td>
        </tr>
<%
}
%>
</table>

<br>
<input type="button" value="글쓰기" class="btn btn-primary" onclick="location.href='write.jsp'">

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  </body>
</html>
