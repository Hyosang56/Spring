<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주민(resident) 회원가입 페이지</title>
</head>
<body>
	<form action="<c:url value='/resident/insertResident' />" 
				name="create_account_form" method="post">	
	    <table>
	        <tr>
	            <td>아이디(6-8 문자):</td>
	            <td><input type="text" name="a_m_id" required></td>
	        </tr>
	        <tr>
	            <td>이름:</td>
	            <td><input type="text" name="a_m_name" required></td>
	        </tr>
	        <tr>
	            <td>글 내용:</td>
	            <td><input type="text" name="a_m_content" required></td>
	        </tr>
	        <tr>
	            <td>주소:</td>
	            <td><input type="text" name="a_m_address" required></td>
	        </tr>
	        <tr>
	            <td>email:</td>
	            <td><input type="text" name="a_m_email" required></td>
	        </tr>
	        <tr>
	            <td>휴대폰:</td>
	            <td><input type="text" name="a_m_phone" required></td>
	        </tr>
	        <tr>
	            <td colspan="2" align="center">
	                <input type="submit" value="전송">
	                <input type="reset" value="리셋">
	            </td>
	        </tr>
	    </table>
	</form>
</body>
</html>

