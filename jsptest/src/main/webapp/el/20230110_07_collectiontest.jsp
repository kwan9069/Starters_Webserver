<%@page import="java.util.HashMap"%>
<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
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
String array[]={"red","black","white","green","blue"};
pageContext.setAttribute("colors",array);
%>
${colors[0] }:${pageScope.colors[0] }:${colors[0].toUpperCase() }<br>
${colors[100] }:${pageScope.colors[100] }:${colors[100].toUpperCase() }<br>
${Integer.parseInt("100")+100 }<br>
${"100"+="100" }<br>


<jsp:useBean id="list" class="java.util.ArrayList"/>
<jsp:useBean id="dto" class="dto.MemberDTO"/>
<jsp:setProperty property="id" name="dto" value="el"/>
<%
// ArrayList<MemberDTO> list=new ArrayList();
list.add(dto);
list.add(new MemberDTO("MEM1","1","회원1","01012341234","이메일1@a.com","서울시 용산구", "2022-12-12"));
list.add(new MemberDTO("MEM2","2","회원2","01012344321","이메일2@a.com","부산시 용산구","2023-01-12"));
list.add(new MemberDTO("MEM3","3","회원3","01043211234","이메일3@a.com","제주시 용산구","2012-08-12"));
list.add(new MemberDTO("MEM4","4","회원4","01043214321","이메일4@a.com","전주시 용산구","2022-08-12"));
list.add(new MemberDTO("MEM5","5","회원5","01012345678","이메일5@a.com","청주시 용산구","2022-08-12"));
//((MemberDTO)list.get(0)).getId();

%>

${list.get(0).id}:${list[0].id }<br>
${list.get(1).id}:${list[1].id }<br>
${list.get(2).id}:${list[2].id }<br>
${list.get(3).id}:${list[3].id }<br>
${list.get(4).id}:${list[4].id }<br>

<%
HashMap<String,String> map=new HashMap();
map.put("빨강","red");
map.put("주황","orange");
map.put("노랑","yellow");
map.put("초록","green");
map.put("파랑","blue");
map.put("남색","navy");
map.put("보라","purple");
map.put("빨강","purple");//빨강이 바뀜 HashMap key 중복 불가능
map.put("one","black");
pageContext.setAttribute("colormap", map);
%>

${colormap["빨강"]}<br>
${empty colormap["빨강색"]?"해당색상없음":colormap["빨강색"]}<br>

${colormap.one }<br>

</body>
</html>