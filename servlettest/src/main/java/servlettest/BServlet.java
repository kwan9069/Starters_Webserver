package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BServlet
 * @WebServlet("/b")
 * http://localhost:8081/servlettest/b
 */
@WebServlet("/b")
public class BServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("두번째 만드는 서블릿");
		PrintWriter out=resp.getWriter();
		out.println("<h1>hello output</h1>");//클라이언트 브라우저 출력
	}

	
}
