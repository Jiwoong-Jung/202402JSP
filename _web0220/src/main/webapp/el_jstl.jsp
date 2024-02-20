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
${aaa = 10}<br>
${aaa += 10}<br>
${'문자' += '열' += ' 붙이기'}<br>
${"1"+10}<br>
${123+'100'+'10'}<br>
${100+20; 30+1}<br>
${sum = 10; ''}<br>
${sum = sum + 100; ''}<br>
${name = '홍길동'}<br>
${name == '강감찬' }<br>
${empty sum }
${sum}
</body>
</html>



