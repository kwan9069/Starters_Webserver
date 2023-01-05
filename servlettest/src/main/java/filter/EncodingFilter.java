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

@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("FILTER 시작");
		//모든 서블릿 실행시마다(요청) 서블릿이름,요청클라이언트IP 출력 후에 - 서블릿 doGet.Post
		String servletname = ((HttpServletRequest)request).getServletPath();
		String clientip = request.getRemoteAddr();//0.0.0.0.
		System.out.println(clientip + " 컴퓨터가 " + servletname + " 을 호출했습니다.");
		
		//서블릿 요청인코딩 변경(get(변화없다)/post(o) )
		// spring 그대로 적용
		request.setCharacterEncoding("utf-8");
		
		// 요청 - 요청필터 - 처리 - 응답필터 -  응답
		long start = System.currentTimeMillis();
		chain.doFilter(request, response); //다른 필터 실행. 다른 필터 없으면 서블릿 실행
		long stop = System.currentTimeMillis();
		System.out.println((stop - start) + "실행 소요 시간(1/1000초)");
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
