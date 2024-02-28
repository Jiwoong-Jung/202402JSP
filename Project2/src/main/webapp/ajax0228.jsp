<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="target" style="width: 300px; height: 60px; border: solid 1px black;">
    </div>
    <button type="button" onclick="getFromServer()">GET DATA</button>
    <script>
        function getFromServer() {
            const xhttp = new XMLHttpRequest();
            xhttp.onload = function () {
                document.getElementById("target").innerHTML =
                    this.responseText;
            }
            xhttp.open("GET", "list.jsp");
            xhttp.send();
        }
    </script>
</body>
</html>