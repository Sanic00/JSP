package com.logon.cookie;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;


public class LoginDBBean {
		
	private static LoginDBBean instance = new LoginDBBean();

	public static LoginDBBean getInstance() {
		return instance;
	}
	
	
	//생성자 객체를 더 생성 안시키기 위해
	private LoginDBBean() {}
		
	//db 연결
	private Connection getConnection() throws Exception {
		DataSource ds ; 
		
		Context initContext = new InitialContext();								 
		 ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
	
		return ds.getConnection();
	}
	
	// 사용자 인증(아이디, 비밀번호)
	
	public int userCheck (String id, String passwd)throws Exception{
	
		Connection conn = null;
		PreparedStatement pstmt = null;  //바인딩할때 동적이라서 preparedst.. 써야됨
		ResultSet rs = null;
		String dbpasswd = "";
		
		
		
		//일단은 아이디 없는걸로 설정
		int check = -1; 
		
		try {
			conn = getConnection(); //db연결
			
			//쿼리문 날리기 
			String strQuery = "select passwd from tempmember where id =?";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery(); //select 조회이기 때문에
			if(rs.next()) {
				 dbpasswd = rs.getString("passwd");
				if(dbpasswd.equals(passwd)) check=1;// 회원인증 성공
				else check = 0; // 비밀번호 오류
			}else {
				check = -1; //아이디가 없음
			}
			
		}catch(SQLException s1) {	
			s1.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return check;
	}
	
	
	
}
