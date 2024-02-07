<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length > 0) {
		for (Cookie ck : cookies) {
			if (ck.getName().equals(name)) {
				Cookie cookie = new Cookie(name, "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}
	response.sendRedirect("listCookies.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>