package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

public class MemberDAO {
	
	public int insertMember(MemberDTO dto){
		// dto 전달 내용을 member 테이블 입력
		// 회원가입일 now() 설정
		
		Connection con = null;
		int count = 0;
		
		MemberDTO selecteddto = getMember(dto.getId(), dto.getPw());//연결 - 해제
		
		System.out.println(selecteddto);
		if(selecteddto.getId() != null) {
			System.out.println("아이디 중복입니다. 다른 아이디를 입력하세요");
			return 0;//메소드 중단
		}
		
		try {
			//0. jdbc driver 호출 - jdk 비포함
			Class.forName(ConnectionInform.DRIVER_CLASS);
			
			// 1. db 연결
			con = DriverManager.getConnection
					(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			
			System.out.println("연결 성공");
			System.out.println(con.getAutoCommit());
			
			String sql = "INSERT INTO member " +
						 "VALUES(?, ?, ?, ?, ?, ?, now());";
			
			PreparedStatement pt = con.prepareStatement(sql);
			
			pt.setString(1, dto.getId());
			pt.setString(2, dto.getPw());
			pt.setString(3, dto.getName());
			pt.setString(4, dto.getPhone());
			pt.setString(5, dto.getEmail());
			pt.setString(6, dto.getAddress());
			
			count = pt.executeUpdate();
			
			System.out.println("삽입행의 갯수 = " + count);
			
			con.close();
			System.out.println("연결 해제");
			
		}catch(ClassNotFoundException e) {
		System.out.println("해당 드라이버가 발견되지 않습니다.");//?????
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
			con.close();//throws 	SQLEXCRPTION
			}catch(SQLException e) {}
		}
	
		return count;
	} //insertMember end
	
	int getTotalMember(){
		// dto 전달 내용을 member 테이블 입력
		// 회원가입일 now() 설정
		
		Connection con = null;
		int count = 0;
		
		try {
			//0. jdbc driver 호출 - jdk 비포함
			Class.forName(ConnectionInform.DRIVER_CLASS);
			
			// 1. db 연결
			con = DriverManager.getConnection
					(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			
			System.out.println("연결 성공");
			System.out.println(con.getAutoCommit());
			
			String sql = "SELECT count(*) FROM member";
			
			PreparedStatement pt = con.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			rs.next();
			
			if(rs.getString("count(*)") == null) {
				count = 0;
			}
			else {
				count = rs.getInt("count(*)");
			}
			
			pt.close();
			con.close();
			System.out.println("연결 해제");
			
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			con.close();//throws 	SQLEXCRPTION
			}catch(SQLException e) {}
		}
	
		return count;
	} //getTotalMember end
	
	public ArrayList<MemberDTO> getMemberList(int page, int memberPerPage){
		
		ArrayList<MemberDTO> result = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pt = null;
		int count = 0;
		
		try {
			Context initContext = new InitialContext(); //context.xml 준비
			Context envContext = (Context)initContext.lookup("java:/comp/env"); //자바 연관 설정
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			con = ds.getConnection();
			
//			//0. jdbc driver 호출 - jdk 비포함
//			Class.forName(ConnectionInform.DRIVER_CLASS);
//			
//			// 1. db 연결
//			con = DriverManager.getConnection
//					(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
//			
//			System.out.println("연결 성공");
//			System.out.println(con.getAutoCommit());
			
			
//			 "INSERT(pw, 2, char_length(pw)-1, repeat(\"*\", char_length(pw) - 1)) AS pw, "
			String sql = 
				"SELECT id, insert(pw, 2, char_length(pw)-1, repEAT(\"*\",char_length(pw)-1 ) ) as pw, "
			  + " name, address, indate FROM MEMBER ORDER BY INDATE LIMIT ?, ?";//1행 1열(null / 숫자)
			
			pt = con.prepareStatement(sql);
			
			pt.setInt(1, (page-1) * memberPerPage); //page = 1이면 0인덱스, 
			pt.setInt(2, memberPerPage); // 
//			
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO(rs.getString("id"),
												rs.getString("name"),
												rs.getString("indate"));
				
				dto.setPw(rs.getString("pw"));
				dto.setAddress(rs.getString("address"));
				result.add(dto);
			}
						
			con.close();
			System.out.println("연결 해제");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			con.close();//throws 	SQLEXCRPTION
			}catch(SQLException e) {}
		}
	
		return result;
	} //getMemberList end
	
	
	public MemberDTO getMember(String id, String pw){
		
		MemberDTO result = new MemberDTO();
		
		Connection con = null;
		PreparedStatement pt = null;
		MemberDTO dto = null;
		
		try {
			Context initContext = new InitialContext(); //context.xml 준비
			Context envContext = (Context)initContext.lookup("java:/comp/env"); //자바 연관 설정
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			con = ds.getConnection();
			
			
//			initContext.lookup("java:/comp/env"); //자바 연관 설정 찾아라
			
			
			
//			//0. jdbc driver 호출 - jdk 비포함
//			Class.forName(ConnectionInform.DRIVER_CLASS);
//			
//			// 1. db 연결
//			con = DriverManager.getConnection
//					(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
//			
//			System.out.println("연결 성공");
//			System.out.println(con.getAutoCommit());
			
			String sql = "SELECT * FROM member WHERE id = ?";
			pt = con.prepareStatement(sql);
			pt.setString(1, id);
			
			ResultSet rs = pt.executeQuery();
			
			//확인용
//			System.out.println(rs.next());
			
			if(rs.next()) {
				String dbpw = rs.getString("pw");
				if(pw.equals(dbpw)) {
					result = new MemberDTO
							(rs.getString("id"), rs.getString("pw"),
									rs.getString("name"), rs.getString("email"),
									rs.getString("phone"), rs.getString("address"),
									rs.getString("indate"));
				}
				else {
					result = new MemberDTO();
					result.setId(rs.getString("id"));
					System.out.println("암호 맞지 않습니다. 4번 입력하세요");
				}
			}
			else {
				System.out.println("1번 회원가입부터 하세요");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pt.close();
				con.close();
			}catch(Exception e) {}
		}
	
		return result;
	} //getMember end
	
	void updateMember(HashMap<String, String> updateMap){
		
		Connection con = null;
		PreparedStatement pt = null;
		
		try {
			//0. jdbc driver 호출 - jdk 비포함
			Class.forName(ConnectionInform.DRIVER_CLASS);
			
			// 1. db 연결
			con = DriverManager.getConnection
					(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			
			StringBuffer sql = new StringBuffer(); //16문자 버퍼 + ...
			
			sql.append("UPDATE member SET ");
			//확인용
			Set<String> keys = updateMap.keySet();
			for(String k : keys) {
				if(!k.equals("id")) {
					sql.append(k + "= '" + updateMap.get(k) + "', ");
				}
			}
			sql.deleteCharAt(sql.lastIndexOf((",")));
			sql.append("WHERE id = ?");
			
			System.out.println("연결 성공");
			System.out.println(sql);// 확인용
			
			pt = con.prepareStatement(sql.toString());
			pt.setString(1,updateMap.get("id"));
			pt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pt.close();
				con.close();
			}catch(Exception e) {}
		}

	} //updateMember end
	
	void deleteMember(String id){
		Connection con = null;
		PreparedStatement pt = null;
		//int count = 0;
		
		try {
			//0. jdbc driver 호출 - jdk 비포함
			Class.forName(ConnectionInform.DRIVER_CLASS);
			
			// 1. db 연결
			con = DriverManager.getConnection
					(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			
			con.setAutoCommit(false); //수동 트랜잭션 설정 변경
			
			System.out.println("연결 성공");
			System.out.println(con.getAutoCommit());
			
			String sql1 = "INSERT INTO deletedmember SELECT * FROM member WHERE id = ?";
			String sql2 = "DELETE FROM member WHERE id =?";
			
			pt = con.prepareStatement(sql1);
			pt.setString(1, id);
			int insertcount = pt.executeUpdate();
			
			pt = con.prepareStatement(sql2);
			pt.setString(1, id);
			int deletecount = pt.executeUpdate();
			
			con.commit();
			
			//확인용
//			System.out.println(rs.next());
		
			
		}catch(Exception e) {
			System.out.println("회원 탈퇴 처리 중 문제 발생 - 취소");
			try {
				con.rollback();
			}catch(Exception e2) {}
//			 e.printStackTrace();
		}finally {
			try {
				pt.close();
				con.close();
			}catch(Exception e) {}
		}
	} //deleteMember end

}