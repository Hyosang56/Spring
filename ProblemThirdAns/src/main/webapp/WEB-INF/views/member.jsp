<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Page</title>
<style>
        a {
            color: blue;
            text-decoration: underline;
        }
    </style>
</head>
<body>
	<h1>memJoinOk</h1>
    <form action="/center/memberJoin" method="get">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" /><br/>

        <label for="pw">PW:</label>
        <input type="password" id="pw" name="pw" /><br/>

        <label for="mail">Mail:</label>
        <input type="email" id="mail" name="mail" /><br/>

        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" /><br/>

        <input type="submit" value="Go MemberJoin" />
    </form>

    <!-- 파란색 링크 -->
    <a href="/center/memberJoin">Go MemberJoin</a>
</body>
</html>