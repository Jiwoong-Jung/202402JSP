<%@page import="java.net.URLDecoder"%>
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
쿠키이름<input type="text" name="name" value="<%=nameU %>"/><br/>
쿠키 값&nbsp;&nbsp;<input type="text" name="value" value="<%=valueU %>"/><br/>
</form>
<button onclick="insert()">입력</button>
<button onclick="update()">수정</button>
<button onclick="clean()">초기화</button>
<table>
    <tr>
        <th>쿠키 이름</th><th>쿠키 값</th><th>삭제</th>
    </tr>
<%
Cookie[] cookies = request.getCookies();
if (cookies != null && cookies.length > 0) {
	for (Cookie ck : cookies) {
		if(!ck.getName().equals("JSESSIONID")) {
%>          
            <tr>
				<td><%=ck.getName() %></td>
				<td><%=URLDecoder.decode(ck.getValue(), "utf-8") %></td>
				<td>삭제</td>
            </tr>
           
<% 
		}
	}
}
%>
</table>
<script>
function insert() {
	document.getElementById('frm').action='mkCookie.jsp';
	document.getElementById('frm').submit();
}
function update() {
	document.getElementById('frm').action='updCookie.jsp';
	document.getElementById('frm').submit();
}
function clean() {
	var el = document.getElementById('frm');
	for(var i=0; i<el.length; i++){
		el[i].value = '';
	}

}
</script>
</body>
</html>