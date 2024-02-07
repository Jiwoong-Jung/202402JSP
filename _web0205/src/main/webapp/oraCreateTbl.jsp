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
    Class.forName("oracle.jdbc.driver.OracleDriver");
    try ( 
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        Statement stmt = conn.createStatement();
    ) {
    	
    	String sql = 
                "create table score (" + 
                "    num  number(4)          primary key," + 
                "    name varchar2(20),             " +
                "    kor  number(3),                     " +    
                "    eng  number(3),                     " +
                "    math number(3)                      " +    
                ")";
    	
        stmt.executeUpdate(sql);
        out.println("성적 테이블 생성 성공 !");
        
    } catch(Exception e) {
        e.printStackTrace();
    }
%>

</body>
</html>