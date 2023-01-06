<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
int count=0;
if(application.getAttribute("count")== null){
}
else{
	count=(Integer)application.getAttribute("count")+1;
}
application.setAttribute("count",count);
%>
<h1>서버 시작 후 <%=count%>번째 방문자 입니다.</h1><br>
<h1>환영합니다.</h1>
</body>
</html>