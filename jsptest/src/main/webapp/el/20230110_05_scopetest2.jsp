<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${pageContext.request.contextPath}</h1>

//jsp 태그 값 정의-- el 출력

jsp a 출력(pageContext)=<%=pageContext.getAttribute("a") %><br>
jsp a 출력(request)=<%=request.getAttribute("a") %><br>
jsp a 출력(session)=<%=session.getAttribute("a") %><br>
jsp a 출력(application)=<%=application.getAttribute("a") %><br>
<%-- el b 출력=${b }<br><!-- 공백 --> --%>
el a 출력(현재페이지의 jsp태그 전달값)=${pageScope.a }<br>
el a 출력(이전 페이지 jsp태그 전달값)=${requestScope.a }<br>
el a 출력(세션전달값)=${sessionScope.a }<br>
el a 출력(어플리케이션 전달값)=${applicationScope.a }<br>
e1 컨텍스트명 출력= ${pageContext.request.contextPath }<br>
e1 jsp명 출력= ${pageContext.request.requestURI } <br>

<!-- 
e1 전달변수 해석 출력
1. pageScope 찾는다
2. requestScope
3.sessionScope
4.applicationScope
 -->
%>
</body>
</html>