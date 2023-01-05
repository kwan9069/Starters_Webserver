package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/logindb")
public class LoginDBServlet extends HttpServlet {
	public static final Logger LOG = Logger.getGlobal();
	/*static Level	ALL
          ALL는 모든 메세지의 로그를 취하는 것을 나타냅니다.
static Level	CONFIG
          CONFIG는 정적인 구성 메세지의 메세지 레벨입니다.
static Level	FINE
          FINE는 트레이스 정보를 제공하는 메세지 레벨입니다.
static Level	FINER
          FINER는 꽤 상세한 트레이스 메세지를 나타냅니다.
static Level	FINEST
          FINEST는 극히 상세한 트레이스 메세지를 나타냅니다.
static Level	INFO
          INFO는 메세지를 정보로서 제공하는 메세지 레벨입니다.
static Level	OFF
          OFF는 로그를 오프로 하기 위해서 사용 가능한 특수 레벨입니다.
static Level	SEVERE
          SEVERE는 중대한 장해를 나타내는 메세지 레벨입니다.
static Level	WARNING
          WARNING는 잠재적인 문제를 나타내는 메세지 레벨입니다.
          		LOG.log(Level.INFO, String.format
				("==>: %s", request.getRequestURI()));
          */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1. 요청 정보 추출(id, pw)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id == null || pw == null) {
			out.println("필요 정보를 모두 입력하세요.");
			out.close();
		}
		//2. 로그인 처리-jdbc
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id, pw);
		
		//3. 정상로그인 / 암호 다시 입력 / 회원가입대상 응답 
		/* dto id,pw 저장상태
		 * dto id 저장, pw null
		 * dto null 
		 * */
		String result = "";
		if(dto != null && dto.getPw()!= null) {
			result ="<h1>" + id + " 회원님 정상 로그인되셨습니다.</h1>";
		}
		else if(dto != null && dto.getPw()== null) {
			result ="<h1>" + id + " 회원님으로서 인증되지 않았습니다. "
					+"<a href='login_db.html'>다시로그인하러가기</a></h1>";
		}
		else if(dto == null) {
			result ="<h1>" + id + " 회원가입되지 않았습니다. "
					+"<a href='insert_db.html'>회원가입하러가기</a></h1>";
		}
		out.println(result);
	}

}







