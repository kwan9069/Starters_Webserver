<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- member --- forward --- request.getParameter -->
 <jsp:useBean id="dto" class="dto.MemberDTO" />
 <jsp:setProperty property="*" name="dto"/>
 <jsp:useBean id="dao" class="dao.MemberDAO" scope="request" />
 
 <% 
 dao= (MemberDAO) request.getAttribute("dao"); 
 int result = dao.insertMember(dto);

 if(result == 1){
	  out.println("<h1>회원가입처리되었습니다</h1>");
 }
 %>
 <!-- jsp 내부 독립적 언어 - 변수, 연산자, 조건문 반복문 객체 -->
</body>
</html>