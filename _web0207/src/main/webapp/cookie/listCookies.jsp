<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String nameU = "";    String valueU = "";
%>
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
<form method="post" id="frm">
쿠키 이름<input type="text" name="name" value="<%=nameU %>"/><br/>
쿠키 값<input type="text" name="value" value="<%=valueU %>"/><br/>
</form>
<button onclick="insert()">입력</button>
<button onclick="update()">수정</button>
<button onclick="clean()">초기화</button>
<table>
    <tr>
        <th>쿠키 이름</th><th>쿠키 값</th><th>삭제</th>
    </tr>
<%

%>          
            <tr>
				<td></td>
				<td></td>
				<td></td>
            </tr>
<%          

%>
</table>
</body>
</html>