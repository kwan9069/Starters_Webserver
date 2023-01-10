<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js" ></script>
<script>
$(document).ready(function(){

});

</script>

</head>
<body>
	<!-- url 생성 -->
	<c:url var="mypage" value="http://localhost:8080/jsptest/jstl/20230110_10_loginpage.jsp" />
	
	
<%-- 	<c:url var="mypage" value="http://www.google.com" /> --%>
	<!-- redirect와 forward차이  -->
	<!-- 1> url 최초요청 jsp 불변  -->
	<!-- 2> 같은 서버 같은 어플리케이션 파일 가능  -->
	
<%-- 	<c:redirect url="${mypage}"> --%>
<%-- 		<c:param name="name" value="홍길동" /> --%>
<%-- 		<c:param name="age" value="21" /> --%>
<%-- 	</c:redirect> --%>
	
	
	<!--  jsp:include -->
	<c:import url = "${mypage}">
		<c:param name="name" value="홍길동" />
		<c:param name="age" value="21" />
	</c:import>
		<h1>import한 직후입니다.</h1>
	
</body>
</html>