<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String msg="콘솔출력";
//jsp 서블릿 변환시 _jspservice () 문장 간주
//jsp 서블릿 변환시 _jspservice() 지역변수 간주
 	System.out.println(msg);
%>

<%! String msg2="멤버변수"; 
int multiply(int a, int b){
	System.out.println(msg2+":"+a*b);
	return a*b;}%>


<%= multiply(10,20) %>
</body>
</html>