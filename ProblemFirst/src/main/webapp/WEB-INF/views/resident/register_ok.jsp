<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주민 가입 성공</title>
</head>

<link href="<c:url value='/resources/css/button.css' />" rel="stylesheet" type="text/css">

<body>
    
    <h2>출력페이지</h2>
    
    <table>
        <tr>
            <td>아이디:</td>
            <td>${adminResidentVo.a_m_id}</td>
        </tr>
        <tr>
            <td>이름:</td>
            <td>${adminResidentVo.a_m_name}</td>
        </tr>
        <tr>
            <td>글 내용:</td>
            <td>${adminResidentVo.a_m_content}</td>
        </tr>
        <tr>
            <td>주소:</td>
            <td>${adminResidentVo.a_m_address}</td>
        </tr>
        <tr>
            <td>email:</td>
            <td>${adminResidentVo.a_m_email}</td>
        </tr>
        <tr>
            <td>휴대폰:</td>
            <td>${adminResidentVo.a_m_phone}</td>
        </tr>
    </table>
    <div id="button">
    	<a href="<c:url value='/resident/home.jsp' />">다시입력하기</a>
    </div>

</body>
</html>
