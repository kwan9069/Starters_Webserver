<%@page import="dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%! List<MemberDTO> list; %>
<body>
<%
List <MemberDTO> list = (List<MemberDTO>) request.getAttribute("memberlist");
%>
<%String output="<ul>";%>
<% for(MemberDTO play: String){output+=%>
<li>
<%play.getId();%>:<%play.getName();%>:
<%play.getPw();%>:<%play.getIndate();%>
</li>
<%} output+="</ul>";%>;
out.println(output);



</body>
</html>