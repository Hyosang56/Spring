<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<h1>Login</h1>
    <form action="<c:url value='/center/loginConfirm' />"
    	name="member_login" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" /><br/>

        <label for="pw">PW:</label>
        <input type="password" id="pw" name="pw" /><br/>

        <input type="submit" value="Login" />
    </form>

    <!-- 파란색 링크 -->
    <a href="/center/memberJoin">JOIN</a>
    <a href="/center/main">MAIN</a>
</body>
</html>