<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
============================================
<jsp:useBean id="dto" class="dto.MemberDTO" scope="application" />
<jsp:setProperty property="*" name="dto"  /><!-- dto.setxxxx(request.getParamter("xxxx") -->
</html>








