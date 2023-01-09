<%@page import="java.net.URLEncoder"%>
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
String id=request.getParameter("id"); 
String filename="";
String menu[]=null;
if(id!=null) {
	if(id.equals("admin")||id.equals("adminstrator")){
		filename="admin.jsp";
		menu=new String[3];
		menu[0]="모든 사용자정보조회";
		menu[1]="회원 강제탈퇴";
		menu[2]="상품관리";
	}
	else{
		filename="user.jsp";
		menu=new String[4];
		menu[0]="회원가입";
		menu[1]="상품구입";
		menu[2]="결제";
		menu[3]="장바구니 조회";
	}
	request.setAttribute("menu",menu);
}
else{
	filename="none.jsp";
}
%>

<jsp:forward page="<%=filename %>">
<jsp:param name="username" value="<%= URLEncoder.encode(\"홍길동\")%>"/>
</jsp:forward>
</body>
</html>