<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="js/jquery-3.6.1.min.js"></script> -->

</style>
<form action="http://localhost:8080/jsptest/output.jsp" method="get" name="frm">
시작단: <input type="text" name="start" value=2><br>
종료단: <input type="text" name="end" value=9><br>
관리자 아이디: <input type=text name="id"  value=<%=request.getParameter("id")%>><br>
<input type="submit" value="전송" >구구단 출력버튼</button>

</form>
</body>
</html>