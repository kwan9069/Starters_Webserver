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
	public int insertMember(MemberDTO dto) {
		Connection con = null;
		PreparedStatement pt = null;
		int cnt = 0;
		MemberDTO selecteddto = getMember(dto.getId(), dto.getPw()); // 연결 - 해제

		try {

			Context initContext = new InitialContext(); // context.xml 준비
			Context evContext =( Context )initContext.lookup("java:/comp/env"); //자바 연관 설정
			DataSource ds = (DataSource)evContext.lookup("jdbc/mydb"); 
			con = ds.getConnection(); // 커넥션 pool 빌려온다
			
			
			String sql = "insert into member values(?,?,?,?,?,?,now())";
			pt = con.prepareStatement(sql);
			pt.setString(1, dto.getId());
			pt.setString(2, dto.getPw());
			pt.setString(3, dto.getName());
			pt.setString(4, dto.getPhone());
			pt.setString(5, dto.getEmail());
			pt.setString(6, dto.getAddress());
			cnt = pt.executeUpdate(); // insert

			if (cnt == 1) {
				System.out.println("성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close();//pool로 con반납
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;

	}// insertMember end

	public int getTotalMember() {
		Connection con = null;
		PreparedStatement pt = null;
		int cnt = 0;

		try {
			
			Context initContext = new InitialContext(); // context.xml 준비
			Context evContext =( Context )initContext.lookup("java:/comp/env"); //자바 연관 설정
			DataSource ds = (DataSource)evContext.lookup("jdbc/mydb"); 
			con = ds.getConnection(); // 톰캣한테  커넥션 pool 빌려온다
			
			String sql = "select count(*) from member"; // 1행 1열
			pt = con.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();
			rs.next();
			// rs.getInt(1);
			if (rs.getString("count(*)") == null) {
				cnt = 0;
			} else {
				cnt = rs.getInt("count(*)");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close(); //pool로 con반납 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;

	}

	public ArrayList<MemberDTO> getMemberList(int Page, int memberPerPage) {
		Connection con = null;
		PreparedStatement pt = null;
		int cnt = 0;
		ArrayList<MemberDTO> list = new ArrayList();

		try {
			
			Context initContext = new InitialContext(); // context.xml 준비
			Context evContext =( Context )initContext.lookup("java:/comp/env"); //자바 연관 설정
			DataSource ds = (DataSource)evContext.lookup("jdbc/mydb"); 
			con = ds.getConnection(); // 톰캣한테  커넥션 pool 빌려온다
			
			
			String sql = "select id, insert('pw', 2, char_length(pw)-1,repeat('*',char_length(pw)-1)) as pw, name, indate"
					+ " from member order by indate limit ?,?"; // 1행 1열
			pt = con.prepareStatement(sql);

			pt.setInt(1, (Page - 1) * memberPerPage); // 1,2,3 0,3,6
			pt.setInt(2, memberPerPage);
			ResultSet rs = pt.executeQuery(); // select

			while (rs.next()) {

				MemberDTO dto = new MemberDTO(rs.getString("id"), rs.getString("name"), rs.getString("indate"));

				// rs.getString("id");
				// rs.getString("name");
				// rs.getString("indate");
				dto.setPw(rs.getString("pw"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public MemberDTO getMember(String id, String pw) {
		Connection con = null;
		PreparedStatement pt = null;
		MemberDTO dto = null;

		try {
			Context initContext = new InitialContext(); // context.xml 준비
			DataSource ds =( DataSource )initContext.lookup("java:/comp/env/jdbc/mydb"); //자바 연관 설정
			con = ds.getConnection(); // 톰캣한테  커넥션 pool 빌려온다
			
			String sql = "SELECT * FROM member WHERE id =? ";
			pt = con.prepareStatement(sql);
			pt.setString(1, id);
//			pt.setString(2, pw);

			ResultSet rs = pt.executeQuery(); 

			if (rs.next()) { // 아이디가 존재한다면
				String dbpw = rs.getString("pw");
				if (pw.equals(dbpw)) { // 입력한 pw = db 에 있는pwd가 일치한다면 전체내용 가져오기
					
					dto = new MemberDTO(rs.getString("id"), rs.getString("pw"), rs.getString("name"),
							rs.getString("email"), rs.getString("phone"), rs.getString("address"),
							rs.getString("indate"));
				} else {// id 존재 암호불일치
					dto = new MemberDTO();
					dto.setId(rs.getString("id"));
					System.out.println("암호 맞지않습니다. 다시 4번 입력하세요.");
				}

			} else {  // id 존재하지 않으면  == null 
				System.out.println("1번 가입부터하세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close();// 커넥션닫아주기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	public void updateMember(HashMap<String, String> updateMap) {
		Connection con = null;
		PreparedStatement pt = null;
		try {
			Context initContext = new InitialContext(); // context.xml 준비
			Context evContext =( Context )initContext.lookup("java:/comp/env"); //자바 연관 설정
			DataSource ds = (DataSource)evContext.lookup("jdbc/mydb"); 
			con = ds.getConnection(); // 톰캣한테  커넥션 pool 빌려온다

			StringBuffer sql = new StringBuffer(); // 16문자버퍼 +....
			sql.append("update member set ");
			Set<String> keys = updateMap.keySet();
			for (String k : keys) {
				if (!k.equals("id")) {
					sql.append(k + "= '" + updateMap.get(k) + "' ,");
				}
			}
			sql.deleteCharAt(sql.lastIndexOf(","));// 마지막 ","를 빼라
			sql.append(" where id=?");
			System.out.println(sql); // 쿼리 메인 확인
			pt = con.prepareStatement(sql.toString());
			pt.setString(1, updateMap.get("id"));
			pt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // updateMember

	public void deleteMember(String id) {
		Connection con = null;
		PreparedStatement pt = null;
		MemberDTO dto = null;

		try {
			Context initContext = new InitialContext(); // context.xml 준비
			Context evContext =( Context )initContext.lookup("java:/comp/env"); //자바 연관 설정
			DataSource ds = (DataSource)evContext.lookup("jdbc/mydb"); 
			con = ds.getConnection(); // 톰캣한테  커넥션 pool 빌려온다
			
			con.setAutoCommit(false);// 수동 트렌젝션 설정변경
			
			String sql1 = "INSERT INTO deletedmember SELECT * FROM MEMBER WHERE id =? ";
			String sql2 = "DELETE FROM member WHERE id =? ";
			
			pt = con.prepareStatement(sql1);
			pt.setString(1, id);
			int insertcount = pt.executeUpdate();

			pt = con.prepareStatement(sql2);
			pt.setString(1, id);
			int deletecount = pt.executeUpdate();
			
			con.commit();
			System.out.println("회원 탈퇴 처리 완료");
		} catch (Exception e) {
			System.out.println("회원 탈퇴 처리중 문제발생 - 취소");
			 try {
				con.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			//e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
