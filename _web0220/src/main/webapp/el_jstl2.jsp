<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="true">
무조건 실행<br>
</c:if>
${bbb = 90; '' }
<c:if test="${bbb < 100 }">
bbb는 100보다 작습니다.<br>
</c:if>
</body>
</html>