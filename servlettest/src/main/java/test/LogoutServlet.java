package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mypage2
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		// TODO Auto-generated method stub
		String sessionid=(String)session.getAttribute("id");
		//요청 보낸 브라우저 세션 있니
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//로그인 먼저하고 나서 로그아웃
		if(session.getAttribute("sessionid")!=null) {
			out.println("<h1>"+session.getAttribute("sessionid")+"님 로그아웃 하셨습니다.</h1>");
			session.removeAttribute("sessionid");
			}
		else {
			out.println("<h1>로그아웃 먼저 할 수 없습니다.</h1>");
		}
	}
	}

