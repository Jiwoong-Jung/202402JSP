
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType = "text/html; charset=utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	boolean login = false;
	// Mysql 접속 후 로그인 체크
	String sql = "SELECT count(*) from board where num = ? and writer = ?";
	Class.forName("com.mysql.cj.jdbc.Driver");
	try (
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/project1", "root", "mysql");
		PreparedStatement pstmt = conn.prepareStatement(sql);
	) {
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		try(ResultSet rs = pstmt.executeQuery()) {
			rs.next();
			if (rs.getInt(1) == 1) {  // 로그인 성공 조건
				login = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
	if (login) {
		session.setAttribute("MEMBERID", id);
%>
<html>
<head><title>로그인성공</title></head>
<body>

로그인에 성공했습니다.

</body>
</html>
<%
	} else { // 로그인 실패시
%>
<script>
alert("로그인에 실패하였습니다.");
history.go(-1);
</script>
<%
	}
%>
