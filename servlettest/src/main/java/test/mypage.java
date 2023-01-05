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
@WebServlet("/mypage")
public class mypage extends HttpServlet {
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
		if(session.getAttribute("sessionid")!=null) {
			out.println("<h1>"+session.getAttribute("sessionid")+"님의 회원정보 페이지입니다.</h1>");
			}
		else {
			out.println("<h1><a href='loginsession?id=test&pw=1111'>로그인</a> 먼저 하세요. 그래야 회원정보를 보여줍니다. </h1>");
		}
	}
	}


