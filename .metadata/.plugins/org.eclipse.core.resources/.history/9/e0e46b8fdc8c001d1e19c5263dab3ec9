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
 * Servlet implementation class LoginSessionServlet
 */
@WebServlet("/boardwriting")
public class boardwriting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		// TODO Auto-generated method stub
		String sessionid=(String)session.getAttribute("id");
		//요청 보낸 브라우저 세션 있니
		//로그인 id 공유
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(session.getAttribute("sessionid")!=null) {
			String output="<h1>글쓰기폼</h1>";
			output+="<table border=3>";
			output+="<tr><td>제목</td><td><input type=text name=title></td></tr>";
			output+="<tr><td>내용</td><td><textarea name=contents rows=5 cols 50>"
					+ "</textarea></td></tr>";
			output+="<tr><td> 작성자</td><td><input type=text name=writer value=>"+" "
					+session.getAttribute("sessionid")+ "<readonly></td></tr>";
			output+="</table>";
			out.println(output);
			}
		else {
			out.println("<h1><a href='loginsession?id=test&pw=1111'>로그인</a> 먼저 하세요. 그래야 회원정보를 보여줍니다. </h1>");
		}
	}
	}

