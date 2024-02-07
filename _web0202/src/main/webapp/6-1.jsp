<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<%
    Class.forName("org.mariadb.jdbc.Driver");
    try ( 
        Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/jspdb", "jsp", "1234");
    ) {
    	
        out.println("DB 접속 성공 !");
        
    } catch(Exception e) {
        e.printStackTrace();
    }
%>

</body>
</html>