<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");

//    System.out.println(pw);
    String sql = "select count(*) cnt from score where num = ? and name = ?";
    Class.forName("oracle.jdbc.driver.OracleDriver");
    try ( 
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        PreparedStatement pstmt = conn.prepareStatement(sql);
    ) {
    	pstmt.setInt(1, Integer.parseInt(id));
    	pstmt.setString(2, pw);
    	ResultSet rs = pstmt.executeQuery();

    	rs.next();
    	int res = rs.getInt(1);
//    	System.out.println(res);
    	if (res == 1) {
    		System.out.println("로그인했다");
    	} else {
    		System.out.println("로그인 못했다");
    	}
    	
    } catch(Exception e) {
       System.out.println("오류!");
       e.printStackTrace();
    }
    
    
    if (id.equals("admin") && pw.equals("1234")) {
        Cookie cookie = new Cookie("userId", id);
        cookie.setMaxAge(-1);         // 웹 브라우저가 닫힐 때 쿠키 만료됨
        response.addCookie(cookie);
        
        response.sendRedirect("loginCK.jsp");   // 로그인 메인 화면으로 돌아감
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>