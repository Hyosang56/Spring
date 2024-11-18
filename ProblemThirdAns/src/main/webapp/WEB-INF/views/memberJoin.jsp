<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Join</title>
</head>
<body>
	<h1>Member Join</h1>
    <form action="<c:url value='/center/insertMember' />"
    	name="member_join" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" /><br/>

        <label for="pw">PW:</label>
        <input type="text" id="pw" name="pw" /><br/>

        <label for="mail">Mail:</label>
        <input type="email" id="mail" name="mail" /><br/>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" /><br/>

        <input type="submit" value="Join" />
        <input type="reset" value="Cancel">
    </form>

    <!-- 파란색 링크 -->
    <a href="/center/login">LOGIN</a>
    <a href="/center/main">MAIN</a>
</body>
</html>