package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginprocess")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//login.html(id, pw) 존재
		String id = request.getParameter("id");
		String pw = request.getParameter("pw"); // 한개의 값이 전달 
		// select multiple = mulitple, input type=checkbox
		String[] title = request.getParameterValues("title"); //복수의 값이 전달
		if (id != null && !id.equals("")) {
			System.out.println(id.equals("servlet"));			
		}

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>"+ id + "회원님 환영합니다.</h1>");
		out.println("<h1>"+ pw + "암호를 입력하셨습니다.</h1>");
		for(String t : title) {
			out.println("<h1>"+ t + "을 선택하셨습니다.</h1>");			
		}
	}
	
	//post방식을 받아줄 doPost매서드 필요
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // post방식에서만 필요한 인코딩 설정	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");  
		String[] title = request.getParameterValues("title");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>"+ id + "회원님 환영합니다.</h1>");
		out.println("<h1>"+ pw + "암호를 입력하셨습니다.</h1>");
		for(String t : title) {
			out.println("<h1>"+ t + "을 선택하셨습니다.</h1>");			
		}
	}

}