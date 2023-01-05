package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//http://ip:port/servlettest/mypage.do
@WebServlet("/loginsession")
//@WebServlet("/login/*")
//@WebServlet("/*")
//@WebServlet("*.do")
// 여러개 url로 1개 서블릿 호출
public class LoginSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//요청 보낸 브라우저 세션 있니
		// true(두번째이후 요청)이면 이전 생성 session 대체하고 false(최초요청)이면 session 생성
		HttpSession session = request.getSession();
		
		session.setAttribute("sessionid", id);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(id != null && pw != null) {
			out.println("<h1>로그인하셨습니다.</h1>");
			out.println("<h1>사용 가능한 메뉴는 다음과 같습니다. </h1>");
			out.println("<h1> <a href='bank'> 은행 업무 보기 </a> </h1>");
			out.println("<h1> <a href='mypage'> 내정보 보러 가기</a> </h1>");
			out.println("<h1> <a href='boardwriting'> 글쓰러 가기</a> </h1>");
			out.println("<h1> <a href='logout'> 로그아웃하러 가기</a> </h1>");
			out.println("<testh1> 로그인정보 유효 시간은 " + session.getMaxInactiveInterval() + " 초입니다. </h1>");
		}
		else {
			out.println("<h1>로그한 적이 없습니다</h1>");
		}
		
	}

}








