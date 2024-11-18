<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link href="<c:url value='/resources/css/button.css' />" rel="stylesheet" type="text/css">

<body>
	<h1>memJoinOk</h1>
    <table>
        <tr>
            <td>ID:</td>
            <td>${memberVo.id}</td>
        </tr>
        <tr>
            <td>PW:</td>
            <td>${memberVo.pw}</td>
        </tr>
        <tr>
            <td>MAIL:</td>
            <td>${memberVo.mail}</td>
        </tr>
        <tr>
            <td>PHONE:</td>
            <td>${memberVo.phone}</td>
        </tr>
      </table>

    <!-- 파란색 링크 -->
    <a href="/center/memberJoin">Go MemberJoin</a>
</body>
</html>