<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
        table { width: 400px; text-align: center; }
        th    { background-color: cyan; }
	</style>
</head>
<body>
<form action="insert.jsp" method="post">
번호<input type="text" name="num" /><br/>
이름<input type="text" name="name" /><br/>
국어<input type="text" name="kor" /><br/>
영어<input type="text" name="eng" /><br/>
수학<input type="text" name="math" /><br/>
<input type="submit" value="확인"/>
<input type="reset" />
</form>
<table>
    <tr>
        <th>번호</th><th>이름</th>
        <th>국어</th><th>영어</th><th>수학</th>
        <th>총점</th><th>평균</th>
    </tr>
<%
    Class.forName("oracle.jdbc.driver.OracleDriver");
    try ( 
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from score");
    ) {
        while (rs.next()) {
        	int num = rs.getInt("num");
        	String name = rs.getString("name");
            int sum = rs.getInt("kor") + rs.getInt("eng") + 
                      rs.getInt("math");
%>          
            <tr>
                <td><a href="updateForm.jsp?num=<%=num %>"><%=num %></a></td>
                <td><a href="updateForm.jsp?num=<%=num %>"><%=name %></a></td>
                <td><%=rs.getInt   ("kor" )%></td>
                <td><%=rs.getInt   ("eng" )%></td>
                <td><%=rs.getInt   ("math")%></td>
                <td><%=sum%></td>
                <td><%=String.format("%.2f", (float)sum / 3)%></td>
            </tr>
<%          
        }
        
    } catch(Exception e) {
        e.printStackTrace();
    }
%>
</table>

</body>
</html>