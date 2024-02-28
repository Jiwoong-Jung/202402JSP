
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String mno = request.getParameter("memberno");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
String sql = "select * from member where memberno = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, Integer.parseInt(mno)); 
ResultSet rs = pstmt.executeQuery();
int memberno = 0;
String id = null;
String email = null;
String name = null;
if (rs.next()) {
	memberno = rs.getInt("memberno");
	id = rs.getString("id");
	email = rs.getString("email");
	name = rs.getString("name");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<div class="container" style="padding-top: 50px">
		<form action="memberUpdate.jsp" method="post">
			<div class="mb-3">
				<label for="membernoInput" class="form-label">회원번호</label>
				<input type="text" readonly name="memberno" value="<%=memberno %>" class="form-control" id="membernoInput" placeholder="회원번호">
			</div>
			<div class="mb-3">
				<label for="idInput" class="form-label">아이디</label>
				<input type="text" name="id" value="<%=id %>" class="form-control" id="idInput" placeholder="아이디">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">이메일</label>
				<input type="email" name="email" value="<%=email %>" class="form-control"
					id="exampleFormControlInput1" placeholder="name@example.com">
			</div>
			<div class="mb-3">
				<label for="nameInput" class="form-label">이름</label>
				<input type="text" name="name" value="<%=name %>" class="form-control" id="nameInput" placeholder="이름">
			</div>
			<button class="btn btn-primary">수정</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>