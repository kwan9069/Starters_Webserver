<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dto" class="dto.MemberDTO"/>
<jsp:setProperty property="id" name="dto" value="elid"/>
<jsp:setProperty property="pw" name="dto" value="elpw"/>
<jsp:setProperty property="name" name="dto" value="김루아"/>
<jsp:setProperty property="email" name="dto" value="el@gmail.com"/>
<jsp:setProperty property="phone" name="dto" value="0101112222"/>
<jsp:setProperty property="address" name="dto" value="서울"/>
<jsp:setProperty property="indate" name="dto" 
value="<%=new SimpleDateFormat(\"yyyy년도 MM월 dd일\").format(new Date()) %>"/>

<H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?(액션태그)</H1>
<h3>아이디:<jsp:getProperty property="id" name="dto"/> </h3>
<h3>암호:<jsp:getProperty property="pw" name="dto"/> </h3>
<h3>이름:<jsp:getProperty property="name" name="dto"/> </h3>
<h3>폰:<jsp:getProperty property="phone" name="dto"/> </h3>
<h3>이메일:<jsp:getProperty property="email" name="dto"/> </h3>
<h3>주소:<jsp:getProperty property="address" name="dto"/> </h3>
<h3>가입일:<jsp:getProperty property="indate" name="dto"/> </h3>


<H1> 회원정보를 생성 완료했습니다. 확인해 볼까요?(액션태그)</H1>
<h3>아이디:${dto.id }</h3>
<h3>암호:${dto.pw }</h3>
<h3>이름:${dto.name } </h3>
<h3>폰:${dto.phone}</h3>
<h3>이메일:${dto.email } </h3>
<h3>주소:${dto.address } </h3>
<h3>가입일:${dto.indate } </h3>

<%=dto.getId() %>
</body>
</html>