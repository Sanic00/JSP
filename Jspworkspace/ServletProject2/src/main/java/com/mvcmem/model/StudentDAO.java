package com.mvcmem.model;

import java.sql.*;
import javax.sql.*;

import com.boardone.BoardDAO;

import javax.naming.*;
import java.util.*;
//com.mvcmem.control 안에 있는 패키지임 착각하지마라
public class StudentDAO {
		
	//싱글톤 패턴으로 하기 위해 생성자 생성
	private static  StudentDAO instance = null;
	
	
	private StudentDAO() {
		
	}
	
	public static StudentDAO getInstance() {
		
		if(instance ==null) {
			synchronized (StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
			return instance;
	}

	
		//메소드임
		private Connection getConnection() {
			
			Connection conn = null;
			
			try {
				
				 Context initContext = new InitialContext();								 
				 DataSource	ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
				 conn = ds.getConnection();
			
			}catch(NamingException e) {
				System.out.println("Connection 생성 실패!!!!!!!!!!");
				e.printStackTrace();
				 
			} catch(Exception e) {
				System.out.println("Connection 생성 실패!!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
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
				//쿼리문 날리기 회원가입 폼에서 ->DB로
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
		}// end of memberInsert
		
		/*
		 * 로그인 버튼을 클릭하면 입력한 아이디와 비밀번호를 데이터베이스에 저장되어 있는 
		 * 아이디와 비밀번호를 비교해서 같으면 로그인 성공 다르면 실패 처리를 해야함
		 * 데이터 베이스에서 아이디와 비밀번호를 비교하여 그 결과를 정수형으로 리턴해주는 메소드를 구현
		 * 정수형 1: 로그인 성공 , 0 : 비밀번호 오류, -1 : 아이디 없음  <-이거를 리턴
		 * 
		 */
		
		//아이디와 비밀번호를 매개변수로 가져와야됨
		public int loginCheck(String id, String pass) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;  //바인딩할때 동적이라서 preparedst.. 써야됨
			ResultSet rs = null;
			
			//일단은 아이디 없는걸로 설정
			int check = -1; 
			
			try {
				conn = getConnection(); //db연결
				
				//쿼리문 날리기 
				String strQuery = "select pass from student where id =?";
				pstmt = conn.prepareStatement(strQuery);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery(); //select 조회이기 때문에
				if(rs.next()) {
					String dbPass = rs.getString("pass");
					if(pass.equals(dbPass)) check=1;//위에 파라미터값으로 들어온거를 비교 
					else check = 0;
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
		} //end of loginCheck
		
		
		//로그인이 된후에 정보수정 DB에서 끌어다 써야됨
		//자바에서는 vo에 저장됨
		public StudentVO getMember(String id) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;  //바인딩할때 동적이라서 preparedst.. 써야됨
			ResultSet rs = null;
			
			//VO객체 선언
			StudentVO vo = null; 
			
			try {
				
				conn = getConnection();
				String strQuery = "select * from student where id=?";
				pstmt = conn.prepareStatement(strQuery);
				
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) { //아이디에 해당하는 회원이 존재한다면 가져와야됨
					//객체먼저 가져옴
					vo = new StudentVO();
					//db에서 가져와야됨 rs에서 가져오는거는 DB컬럼명이랑 같아야됨
					vo.setId(rs.getString("id"));
					vo.setPass(rs.getString("pass"));
					vo.setName(rs.getString("name"));
					vo.setPhone1(rs.getString("phone1"));
					vo.setPhone2(rs.getString("phone2"));
					vo.setPhone3(rs.getString("phone3"));
					vo.setZipcode(rs.getString("zipcode"));
					vo.setAddress1(rs.getString("address1"));
					vo.setAddress2(rs.getString("address2"));
				}
				
				
			} catch(SQLException s1) {	
				s1.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try{rs.close();}catch(SQLException s1){}
				if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
				if(conn != null) try{conn.close();}catch(SQLException s3){}		
			}
			
			return vo;
			
		}
		
		//정보수정 버튼을 클릭했을 경우 DB에  update를 수행시켜 저장 시켜야됨
		// 정보수정 처리를 할 수 있는 메소드 구현 
	 
		public void updateMember(StudentVO vo) {
			//rs는 이미 getmeber에서 가져왔기 때문에 안써도됨
			Connection conn = null;
			PreparedStatement pstmt = null;  //바인딩할때 동적이라서 PreparedStatement 써야됨
	
			try {
				
				conn = getConnection();
	String strQuery = "update student set pass = ?, phone1=?, phone2=?, phone3=?, email=?, zipcode=?,address1=?,address2=? where id=?";
				pstmt = conn.prepareStatement(strQuery);
				
				pstmt.setString(1, vo.getPass());
				pstmt.setString(2, vo.getPhone1());
				pstmt.setString(3, vo.getPhone2());
				pstmt.setString(4, vo.getPhone3());
				pstmt.setString(5, vo.getEmail());
				pstmt.setString(6, vo.getZipcode());
				pstmt.setString(7, vo.getAddress1());
				pstmt.setString(8, vo.getAddress2());
				pstmt.setString(9, vo.getId());
				
				pstmt.executeUpdate();
				
				
				
				
			} catch(SQLException s1) {	
				s1.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
				if(conn != null) try{conn.close();}catch(SQLException s3){}		
			}
			
		} //end of updateMember
		
		
		/*
		 * 회원탈퇴 버튼을 클릭하면 데이터베이스에 회원데이터가 삭제되어야 한다.
		 * 데이터베이스에서 삭제처리해줄 메소드 구현 
		 */
		
		public int deleteMember(String id, String pass) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;  //바인딩할때 동적이라서 preparedst.. 써야됨
			ResultSet rs = null; //정보가 rs에 저장되있으니 가져와야됨
			
			String dbPass = ""; // DB에 저장되어 있는 비밀번호를 의미함
			
		   // 결과값을 반환해줄 변수
			int result = -1; 
			
			try {
				conn = getConnection();
				
				
				String strQuery = "select pass from student where id=?";
				
				pstmt = conn.prepareStatement(strQuery);
				
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				//데이터가 있다면
				if(rs.next()) {
										 	//이거 db테이블 컬럼임
					dbPass = rs.getString("pass");
					
					//일치 한다면 (본인확인) ==> true int형으로 1임
					if(dbPass.equals(pass)) {
						pstmt = conn.prepareStatement("delete from student where id =?");
						pstmt.setString(1, id);
						pstmt.executeUpdate();
						
						result = 1; // 회원탈퇴 성공
					} else { //비밀번호 오류 --> 본인 확인 실패
						result = 0;
					}
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
			
			return result;
			
			
			
		}
		
		
		
		
}
