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
<!--el과 jstl 사용 위주
1. name, age 파라미터 입력받는다
2. name, age 모두 입력되었다면
   2-1. age >= 20  xxxx 님 성인인증되셨습니다 출력
   2-2. age >= 17 && age <= 19 xxx님 고등학생입니다 출력
   2-3. age >= 1 xxx님 미성년입니다 출력
   2-4. 나머지 잘못된 나이입니다 출력
3. 2번 외인 경우 필요한 데이터를 입력해 주세요 출력
-->
<c:set var="name" value="${!empty param.name }"/>
<c:set  var="age" value="${!empty param.age }"/>
<c:if test="${name && age }">
<c:choose>
	<c:when test="${ param.age>=20 }">
		<h1 style="color:blue"> ${param.name} 님 성인 인증 되셨습니다.</h1>
	</c:when>
	<c:when test="${param.age>=17 }">
		<h1 style="color:green"> ${param.name} 님 고등학생입니다.</h1>
	</c:when>
	<c:when test="${param.age>=1 }">
		<h1 style="color:black"> ${param.name} 님 미성년입니다.</h1>
	</c:when>
	<c:otherwise>
		<h1 style="color:red"> ${param.name} 님 잘못된 나이입니다..</h1>
	</c:otherwise>
</c:choose>
</c:if>
<c:if test="${!name||!age}">
<h1 style="color:red">필요한 데이터를 입력하세요.</h1>
</c:if>
</body>
</html>