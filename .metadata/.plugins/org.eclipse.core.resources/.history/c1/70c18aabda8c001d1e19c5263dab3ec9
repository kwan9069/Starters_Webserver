package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.ConnectionInform;

/**
 * Servlet implementation class ConnectionServlet
 */
@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			
			Context initContext=new InitialContext();
			Context envContext= (Context)initContext.lookup("java:/comp/env");
			DataSource ds=(DataSource)envContext.lookup("jdbc/mydb");
			

			//1.db 연결
			long start=System.currentTimeMillis();
			for(int i=1; i<=10000;i++) {
			Connection con=ds.getConnection();//pool con 빌려온다
			System.out.println(i+" 번째 mariaDB 연결 성공");
			con.close(); //반납
			}
			long end=System.currentTimeMillis();
			System.out.println((end-start)+"(1/1000초) 소요");
			}//429 (1/1000초) 소요. 두번째 실행 시 더 짧아짐
		catch(Exception e) {
								e.printStackTrace();}
						}
		}//class

//			Class.forName(ConnectionInform.DRIVER_CLASS);
//			//1.db 연결
//			long start=System.currentTimeMillis();
//			for(int i=1; i<=10000;i++) {
//			Connection con = DriverManager.getConnection
//			(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
//			System.out.println(i+" 번째 mariaDB 연결 성공");
//			con.close();
//			}
//			long end=System.currentTimeMillis();
//			System.out.println((end-start)+"(1/1000초) 소요");
//			//5144 (1/1000초) 소요. 두번째 실행시 6400 중단 오래걸림
							

//5144 (1/1000초) 소요. 두번째 실행시 6400 중단