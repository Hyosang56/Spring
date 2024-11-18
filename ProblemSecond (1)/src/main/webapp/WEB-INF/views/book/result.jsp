<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <h1>책정보 수정하기</h1>

	<!-- 책 표지 이미지 출력 
    <div>
        <img src="${book.coverImage}" alt="책 표지" width="200px" />
    </div>  -->
    
    <form action="updateBook" method="post">
        <!-- <input type="hidden" name="code" value="${book.code}" /> -->
        <label for="code">아이디:</label>
        <input type="text" id="code" name="code" value="${book.code}" required />
        <br>
        
        
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" value="${book.title}" required />
        <br>

        <label for="author">저자:</label>
        <input type="text" id="author" name="author" value="${book.author}" required />
        <br>

        <label for="price">가격:</label>
        <input type="text" id="price" name="price" value="${book.price}" required />
        원
        <br>

        <button type="submit">수정</button>
    </form>

    <br>
</body>
</html>