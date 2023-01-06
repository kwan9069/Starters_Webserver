<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>spring </h1>
<% String id=request.getParameter("id");
Date now=new Date();
%>
<h1> <%=id %>회원님 <%=now %> 시각에 로그인 하셨습니다.</h1>
</body>
</html>