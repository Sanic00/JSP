package com.bbs;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*; 


//@WebServlet("/VisitInsert")
public class VisitInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
		
	
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		// 클라이언트가 HTTP요청으로 전송한 파라미터(매개변수) 값을 읽어온다.
		String writer = request.getParameter("writer"); //html 파일에 있는 input태그 안에 있는 name을 호출한다.
		String memo = request.getParameter("memo");
		// html에서 호출한 파라미터값을 변수에 저장 시키고 데이터베이스에 넣는다.
		
		
		//스트링 버퍼 객체 생성후에 쿼리문을 날린다.
		StringBuffer sql = new StringBuffer();
		sql.append("insert into visit(no, writer, memo, regdate) ");
		sql.append("values(visit_seq.nextval, ? , ?, sysdate)");
		
		
		//DB연결 
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //orjdbc6를 불러오는 명령어
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
					"scott", "tiger");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, writer);
			pstmt.setString(2, memo);
			
			// 실행 (DB에 삽입 삭제 등 변경이 있을때만 실행)
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}finally {
			try { if(pstmt != null) pstmt.close();}catch(SQLException ee) {}
			try { if(con != null) con.close();}catch(SQLException ee) {}
			}
		
		response.sendRedirect("VisitList");
	}
		
		
		
	
	}


