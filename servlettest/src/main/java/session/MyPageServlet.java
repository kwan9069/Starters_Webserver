package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//요청 보낸 브라우저 세션 있니
		// true(두번째이후 요청)이면 이전 생성 session 공유
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//로그인id 공유
		if(session.getAttribute("sessionid") != null) {
			out.println("<h1>" + session.getAttribute("sessionid") + " 님의 회원정보 페이지입니다.</h1>");
		}

		else {
			out.println("<h1><a href='loginsession?id=test&pw=1111'>로그인</a> 먼저 하세요. 그래야 회원정보를 보여줍니다.</h1>");
		}
		
	}

}








