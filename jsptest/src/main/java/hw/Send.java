package hw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

/**
 * Servlet implementation class Send
 */
@WebServlet("/Send")
public class Send extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String menu=request.getParameter("menu");
		if(menu.equals("memberlist")&&(id.equals("admin"))) {
			MemberDAO dao=new MemberDAO();
			List<MemberDTO> list=dao.getMemberList(Integer.parseInt(request.getParameter("page")), 4);
			request.setAttribute("memberlist", list);
			RequestDispatcher dis=request.getRequestDispatcher("/result.jsp");
			
			dis.forward(request, response);
		}
	}

}
