package com.boardone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	
	//이렇게 하면 외부에서 편집을 하질 못함
	private static BoardDAO instance =null;
	
	//생성자를 private로 
	private BoardDAO() {   }
	
	
	public static BoardDAO getInstance() {
		if(instance ==null) {
		synchronized (BoardDAO.class) {
			instance = new BoardDAO();
		}
	}
		return instance;
	}
	//이곳에서 부터 게시판 작업 기능을 하나씩 메소드를 추가해서 작성 하면 됨
	//insertArticle 글을 데이터 베이스에 추가하는 메소드
	public void insertArticle(BoardVO article) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //rs가 필요한 이유가 답변 글
		
		int num = article.getNum();
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();
		
		int number = 0;
		String strQuery ="";
		
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select max(num) from board"); //보드에서 어느게 젤 큰지
			rs = pstmt.executeQuery();
			
			if(rs.next()) number = rs.getInt(1) +1 ;  //rs에 있다면 1을 추가 
			else number = 1;  //없으면 1
			
			if(num != 0) { // 답변 글 일 경우
											//답변 일 경우 그 화살표가 1개씩 추가 되야됨
				strQuery = "update board set step=step+1 where ref =? and step > ?";
				
				pstmt = conn.prepareStatement(strQuery);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);
				
				//업데이트니깐
				pstmt.executeUpdate();
				
				step = step +1;
				depth = depth +1;
				
			}else { //그렇지 않으면 새글
				ref = number;
				step =0;
				depth =0;
			}			//새글이기에 다들어가야됨
			strQuery = "insert into board(num, writer, email, subject, pass, regdate, ref, step, depth, content, ip)" 
					+ "values(board_seq.nextval, ?,?,?,?,?,?,?,?,?,?)";
				//시퀀스 테이블에 자동으로 하나씩 증가 할 수 있도록 이미 설정해놨음
			
			pstmt = conn.prepareStatement(strQuery);
			//num은 시퀀스가 이미 처리했기 때문에 writer
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getEmail());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getPass());
			pstmt.setTimestamp(5, article.getRegdate());
			pstmt.setInt(6, ref); // 얘는 아까 인트형으로 변환 시켰음
			pstmt.setInt(7, step); // 얘는 아까 인트형으로 변환 시켰음
			pstmt.setInt(8, depth); // 얘는 아까 인트형으로 변환 시켰음
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getIp());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		
	} //end of insertArticle 
	
	/*
	 *  글 작성을 수행하고 나면 list.jsp로 redirect 하다록 되어 있다.
	 *  따라서 결과를 보려면 list.jsp를 작성해야함
	 *  글 전체 글의 개수를 가져와서 목록을 보여줘야 된다.
	 */
	
	//전체 글이 몇개인지 인트형으로 메소드
	public int getArticleCount() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x =0;
		
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select count(*) from board"); //전체 개수를 얻어 온다
			rs = pstmt.executeQuery();
			if(rs.next()) {
				x = rs.getInt(1); //첫번째 컬럼을 가져온다 첫번째 컬럼이 num?
			}
			//list를 arraylist에 저장한 다음에 그걸로 뿌려준다.
			
			
		}catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return x;
	}// end of  getArticleCount
	
	/*
	 * board 테이블에서 데이터를 가져와서 보여줄 메소드를 추가
	 * 이때 쓰는것이 List<BoardVO>
	 */
	
	public List<BoardVO> getArticles(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> articleList = null; //리턴할 객체 생성
		
		try {
			conn = ConnUtil.getConnection();                 //내림차순으로
 			pstmt = conn.prepareStatement("select * from board order by num desc");
 			rs = pstmt.executeQuery();
 			
 			if(rs.next()) {
 				articleList = new ArrayList<>();
 				do {
 					
 					BoardVO article = new BoardVO();
 					
 					article.setNum(rs.getInt("num"));
 					article.setWriter(rs.getString("writer"));
 					article.setEmail(rs.getString("email"));
 					article.setSubject(rs.getString("subject"));
 					article.setPass(rs.getString("pass"));
 					article.setRegdate(rs.getTimestamp("regdate"));
 					article.setReadcount(rs.getInt("readcount"));
 					article.setRef(rs.getInt("ref"));
 					article.setStep(rs.getInt("step"));
 					article.setDepth(rs.getInt("depth"));
 					article.setContent(rs.getString("content"));
 					article.setIp(rs.getString("ip"));
 				
 				
 					articleList.add(article);
 				}while(rs.next()); //안에 있으면 계속 반복해서 꺼내라
 				
 			}
			
		}catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return articleList;
	} //end of getArticles
	
	
	
	
}
