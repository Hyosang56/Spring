<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품 코드를 입력하세요</h1>
    
    <!-- 상품 코드 입력 폼 -->
    <form action="searchBook" method="post">
        <label for="code">상품 코드:</label>
        <input type="number" id="code" name="code" required>
        <button type="submit">검색</button>
    </form>

    <br>
    
    <!-- 책을 찾지 못했을 경우 메시지 표시 -->
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>
</body>
</html>