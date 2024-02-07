<%@page import="java.sql.ResultSet"%>
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
String url="jdbc:oracle:thin:@localhost:1521:xe";
Connection conn = DriverManager.getConnection(url, "scott", "tiger");
String sql = "select * from score where num = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, request.getParameter("num"));
ResultSet rs = pstmt.executeQuery();
String num = "";
String name = "";
String kor = "";
String eng = "";
String math = "";
if (rs.next()) {  // 왜 if 일까? 무조건 1건(행, 레코드)
	num = rs.getString("num");
	name = rs.getString("name");
	kor = rs.getString("kor");
	eng = rs.getString("eng");
	math = rs.getString("math");
}
%>
<a href="index.jsp">처음으로</a>
<form method="post" id="frm">
번호<input type="text" name="num" value="<%=num %>"/><br/>
이름<input type="text" name="name" value="<%=name %>"/><br/>
국어<input type="text" name="kor" value="<%=kor %>"/><br/>
영어<input type="text" name="eng" value="<%=eng %>"/><br/>
수학<input type="text" name="math" value="<%=math %>" /><br/>
</form>
<input type="button" onclick="update()" value="수정">
<button onClick="delete2()">삭제</button>
<script>
function delete2() {
//	location.href='delete.jsp?num=<%=num%>';
	document.getElementById('frm').action='delete.jsp';
	document.getElementById('frm').submit();
}
function update() {
	document.getElementById('frm').action='update.jsp';
	document.getElementById('frm').submit();
}
</script>
</body>
</html>



