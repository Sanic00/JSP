package com.memberone;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

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
			
//PreparedStatement 는 미완성된 문장 전달 기능 Statement는 완성형 문장 전달			
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
		
		
		
		
		//zipcodeDAO 회원가입의 일부분이기때문에 따로 만들지 않는다.
		// 우편번호를 데이터베이스에서 검색해서 Vector에 저장한 후 리턴해 주는 메소드 구현 
		// 어마어마한 우편 데이터를 자바에다 불러와서 저장시킬려면 vector를 사용해야된다.
		
		 								//동으로 찾기 때문에 동으로 매개변수로 넣어준다.
		public Vector<ZipCodeVO> zipcodeRead(String dong) {
			
			//DB연결
			Connection conn = null;
			PreparedStatement pstmt = null;  //바인딩
			ResultSet rs = null;   //저장되있는 값
			
			Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
				
			try {
				
				conn = getConnection();  //DB연결
				
				//쿼리 작성
				String strQuery = "select * from zipcode where dong like '"+dong+"%'";
				
				pstmt = conn.prepareStatement(strQuery);                                                                                
				rs = pstmt.executeQuery(); // 수정 삭제이 아니기에 쿼리
				
				while(rs.next()) {
					
					ZipCodeVO tempZipcode = new ZipCodeVO();
					tempZipcode.setZipcode(rs.getString("zipcode"));
					tempZipcode.setSido(rs.getString("sido"));
					tempZipcode.setGugun(rs.getString("gugun"));
					tempZipcode.setDong(rs.getString("dong"));
					tempZipcode.setRi(rs.getString("ri"));
					tempZipcode.setBunji(rs.getString("bunji"));
					
					
					//vector의 객체임
					vecList.addElement(tempZipcode);
				}
				
				
			} catch (SQLException s1) {
				s1.printStackTrace();
			} finally {
				if(rs != null) try{rs.close();}catch(SQLException s1){}
				if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
				if(conn != null) try{conn.close();}catch(SQLException s3){}		
			}
			
			return vecList;
		} // end of zipcodeRead method
		
		/*
		 * 실제로 데이터베이스에 회원데이터를 저장하기 위한 기능(메서드)을 구현
		 * 회원 가입 된 것을 DB로 추가
		 */
		
		
		public boolean memberInsert(StudentVO vo) {
			
			//결과를 리턴받는 함수 설정
			boolean flag = false;  //true가 되면 성공 초기값은 false로
			
			Connection conn = null;
			PreparedStatement pstmt = null;  //바인딩
			ResultSet rs = null;   //저장되있는 값
			
			try {
				
				conn = getConnection();
				//쿼리문 날리기
				String strQuery ="insert into student values(?,?,?,?,?,?,?,?,?,?)";
				
				pstmt = conn.prepareStatement(strQuery);
				
				//rs에서 가져오는게 아닌 vo에서 가져온다.
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPass());
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getPhone1());
				pstmt.setString(5, vo.getPhone2());
				pstmt.setString(6, vo.getPhone3());
				pstmt.setString(7, vo.getEmail());
				pstmt.setString(8, vo.getZipcode());
				pstmt.setString(9, vo.getAddress1());
				pstmt.setString(10, vo.getAddress2());
				
				
				// count값이 0보다 크면 DB안에 들어가는 것을성공하게
				int count = pstmt.executeUpdate();
				if(count > 0) flag = true;
			
			}catch(SQLException s1) {	
				s1.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try{rs.close();}catch(SQLException s1){}
				if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
				if(conn != null) try{conn.close();}catch(SQLException s3){}		
			}
			
			return flag;
		}
		
		
}
