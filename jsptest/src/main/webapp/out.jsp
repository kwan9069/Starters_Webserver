<%@ page language="java" contentType="text/html; charset=UTF-8"
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>버퍼크기: <%=out.getRemaining() %></h1>
<h1>자바문장 실행결과와 html 태그를 모아서</h1>
<h1>응답 내용으로 만들고 버퍼에 저장합니다.</h1>
<h1>예외 발생시 취소합니다.</h1>
<h1>버퍼크기: <%=out.getRemaining() %></h1>
</body>
</html>