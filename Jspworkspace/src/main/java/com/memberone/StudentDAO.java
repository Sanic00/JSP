package com.memberone;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class StudentDAO {
		
//	DataSource ds;
	
		//메소드임
		private Connection getConnection() {
			
			Connection conn = null;
			
			try {
				
				 Context initContext = new InitialContext();								 
			DataSource	ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		
			} catch(Exception e) {
				System.out.println("Connection 생성 실패!!!!!!!!!!!!!!!!!!!!");
			}
			
			return conn;
			
			
		}// DB연결
	
		// 아이디 체크 
		public boolean idCheck(String id) {
			
			boolean result = true;
			Connection conn = null;
			PreparedStatement pstmt = null; 
			ResultSet rs = null; //db에서 가져온다
			
			try {
				//위에 연결 메소드 호출 한거임
 				conn = getConnection();
 												//아이디가 뭔지 모르니 바인딩으로 		
 				pstmt = conn.prepareStatement("select * from student where id = ?");
 				
 				//String 타입으로 저장
 				pstmt.setString(1, id);
 				 
 				//DB 변동에 있을떄는 excuteUpdate 메소드를 써야함 조회만 할때는 쿼리만 씀	
 				rs = pstmt.executeQuery();
 				if(!rs.next()) result = false;
 				
  				
			} catch (SQLException s1) {
				s1.printStackTrace();
			} finally {
				if(rs != null) try{rs.close();}catch(SQLException s1){}
				if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
				if(conn != null) try{conn.close();}catch(SQLException s3){}		
			}
			
			return result;
			
		}//end idCheck
		
}
