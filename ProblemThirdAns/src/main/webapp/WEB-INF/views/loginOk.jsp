<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginOk.jsp</title>
</head>
<body>
	<h1>memLoginOK</h1>
	<table>
        <tr>
            <td>${memberVo.id}</td>
            <td>Login SUCCESS!!</td>
            <td><a href="/center/main">GO Main</a></td>
        </tr>
      </table>
</body>
</html>