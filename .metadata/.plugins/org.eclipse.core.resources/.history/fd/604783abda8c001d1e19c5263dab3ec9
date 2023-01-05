package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter( "/*" )
public class EncodingFilter extends HttpFilter implements Filter {
       
   
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("FILTER 시작");
		//모든 서블릿 실행시마다 서블릿 이름,요청 클라이언트 IP 출력- 서블릿 doGet.Post
		String servletname=((HttpServletRequest)request).getServletPath();
		String clientip=request.getRemoteAddr();
		// 요청- 요청필터 - 처리 - 응답필터 - 응답
		System.out.println(clientip + "컴퓨터가 "+ servletname + "을 호출했습니다.");
		// 서블릿 요청인코딩 변경
		request.setCharacterEncoding("utf-8");
		
		//서블릿 실행
		long start=System.currentTimeMillis();
		chain.doFilter(request, response); //다른 필터 실행. 타른 필터 없으면 서블릿 실행
		long stop=System.currentTimeMillis();
		System.out.println((stop-start)+" 실행 소요 시간(1/1000초)");
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
