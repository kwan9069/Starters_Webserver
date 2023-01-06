<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%MemberDTO dto=(MemberDTO)application.getAttribute("appdto"); %>

ID: <H1><%= dto.getId()%></H1><br>
암호: <H1><%=dto.getPw()%></H1><br>
이름: <H1><%=dto.getName()%></H1><br>

</body>
</html>