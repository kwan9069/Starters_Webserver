<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${param.id}회원님</h1> <br>
${param.pw} 암호를 입력하셨습니다.
<h3>점심주문목록은 <br>
<c:forEach items="${paramValues.lunch}" varStatus="v">
<h3>${v.current }</h3>
</c:forEach>
입니다.
</h3>
</body>
</html>