<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page import = "util.Cookies" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	boolean login = false;

    String sql = "select count(*) as cnt from score where num = ? and name = ?";
    Class.forName("oracle.jdbc.driver.OracleDriver");
    try ( 
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        PreparedStatement pstmt = conn.prepareStatement(sql);
    ) {
    	pstmt.setString(1, id);
    	pstmt.setString(2, pw);
    	ResultSet rs = pstmt.executeQuery();

    	rs.next();
    	int res = rs.getInt("cnt");

    	if (res == 1) {
    		login = true;
    	}
    } catch(Exception e) {
		e.printStackTrace();
    }
	
	if (login) {
		response.addCookie(
			Cookies.createCookie("AUTH", id, "/", -1)
		);
		response.sendRedirect("index.jsp");
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
