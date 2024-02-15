<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>

<%
    // 글 번호 값 얻기, 주어지지 않았으면 0으로 설정
    String tmp = request.getParameter("num");
    int num = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp)
                                                : 0;

    // 새 글쓰기 모드를 가정하고 변수 초기값 설정
    String writer  = "";
    String title   = "";
    String content = "";
    String action  = "insert.jsp";

    // 글 번호가 주어졌으면, 글 수정 모드
    if (num > 0) {

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection conn = DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/project1", "root", "mysql");
            Statement stmt = conn.createStatement();

            // 쿼리 실행
            ResultSet rs = stmt.executeQuery(
                    "select * from board where num=" + num);
        ) {
            if (rs.next()) {
                // 읽어들인 글 데이터를 변수에 저장
                writer  = rs.getString("writer" );
                title   = rs.getString("title"  );
                content = rs.getString("content");

                // 글 수정 모드일 때는 저장 버튼을 누르면 UPDATE 실행
                action  = "update.jsp?num=" + num;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        input[type=text], textarea { width:100%; }
    </style>
</head>
<body>

<form method="post" action="<%=action%>">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"  maxlength="80"
                       value="<%=title%>">
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" maxlength="20"
                       value="<%=writer%>">
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10"><%=content%></textarea>
            </td>
        </tr>
    </table>

    <br>
    <input type="submit" value="저장">
    <input type="button" value="취소" onclick="history.back()">
</form>

</body>
</html>
