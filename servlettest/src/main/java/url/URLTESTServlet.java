package url;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class URLTESTServlet
 */
@WebServlet("/urltest")
public class URLTESTServlet extends HttpServlet {
	//홈페이지 시작화면. 요청 url --> url 분석 =>dao,dto 리턴 /컬렉션 리턴(model) --> 보여줄 화면 (view) 결정	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//http://ip:port/servlettest/product
			//http://ip:port/servlettest/board --> boardwriting
		//http://ip:port/servlettest/member --> forward4
		//http://ip:port/servlettest/product --> 없습니다.
		/*
		 * url uniform resource location 주소 전체
		 * uri uniform resource (서버 내 경로)
		 */
		String uri=request.getRequestURI();
		String uri_arr[]=uri.split("/");
		String forward_uri=uri_arr[uri_arr.length-1];
		System.out.println(forward_uri);
		if(forward_uri.equals("board")) {
			forward_uri= "boardwriting";} //sessionid 세션 정보
		else if(forward_uri.equals("member")) {
			forward_uri="forward4"; //menu=memberlist&page=?
			}
		else {
			System.out.println("이동 url이 없습니다.");
		}
		RequestDispatcher rd=request.getRequestDispatcher(forward_uri);
		rd.forward(request, response);
		
		}
	}

	


