<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/create_account_result.css' />" rel="stylesheet" type="text/css">

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<% 
      String u_id = request.getParameter("a_m_id");
      String u_name = request.getParameter("a_m_name");
      String u_gender = request.getParameter("a_m_gender");
      String u_part = request.getParameter("a_m_part");
      String u_position = request.getParameter("a_m_position");
      String u_mail = request.getParameter("a_m_mail");
      String u_phone = request.getParameter("a_m_phone");
      
   %>
	
	<section>
		
		<div id="section_wrap">
			
			
		
			<div class="word">
				
				<p>회원 아이디 :<%=u_id %><br> <p>
            <p>회원 이름 :<%=u_name %><br> <p>
            <p>회원 성별 :<%=u_gender %><br><p>
            <p>회원 전공 :<%=u_part %><br><p>
            <p>회원 직급 :<%=u_position %><br><p>
            <p>회원 이메일 :<%=u_mail %><br><p>
            <p>회원 전화번호 :<%=u_phone %><br><p>
				
				<h3>CREATE ACCOUNT SUCCESS!!</h3>
				
			</div>
			
			<div class="others">
				
				<a href="<c:url value='/admin/member/loginForm' />">login</a>
				
			</div>
		
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>