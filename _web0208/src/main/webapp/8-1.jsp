<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<%
    String userId = null;

    Cookie[] cookies = request.getCookies();           
    if (cookies != null) {
        for(Cookie cookie : cookies) {           
            if (cookie.getName().equals("userId")) { // userId 쿠키의 값을
                userId = cookie.getValue();          // 변수 userId에 넣음
                break;
            }
        }
    }
    
    if (userId != null) {          // 로그인 상태일 때의 출력 
%>
        <form action="8-3.jsp" method="post"> <!--8-3.jsp:로그아웃 처리--> 
            <%=userId%>님 로그인
            <input type="submit" value="로그아웃"> 
        </form>
<%  
    } else {                       // 로그인되지 않은 상태일 때의 출력
%>
        <form action="8-2.jsp" method="post"> <!--8-2.jsp:로그인 처리-->
            아이디:   <input type="text"     name="id">&nbsp;&nbsp;
            비밀번호: <input type="password" name="pw">
            <input type="submit" value="로그인"> 
        </form>
<%
    }
%>

</body>
</html>