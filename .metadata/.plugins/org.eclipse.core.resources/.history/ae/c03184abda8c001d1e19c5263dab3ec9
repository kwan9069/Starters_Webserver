package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward1")
public class ForwardTest1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		request.setAttribute("upperid", id.toUpperCase());
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =  response.getWriter();
		//out.println("<h1> forwardTest1 클래스입니다</h1>");//무시
		//out.println("<h1>" + request.getAttribute("upperid") + " 회원님 반갑습니다</h1>");
			
		
		RequestDispatcher rd= request.getRequestDispatcher("/forward2");
		rd.forward(request,response);//"이동"요청객체, 응답객체 공유
		//out.println("<h1> forwardTest1 클래스입니다</h1>");//무시
		System.out.println("forwardTest1 클래스입니다");
	}

}






