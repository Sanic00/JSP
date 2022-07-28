package com.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;


@WebServlet("/VisitList")
public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//오타를 줄이기위해 복붙해라 ~
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		try {
			out.println("<html>");
			out.println("<head> <title>방명록 리스트 </title></head>");
			
			out.println("<body>");
			
			StringBuffer sql = new StringBuffer();
			
			// 쿼리문 조회
			sql.append("select no, writer, memo, regdate ");
			sql.append("from visit ");
			sql.append("order by no desc"); //내림차순
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); //orjdbc6를 불러오는 명령어
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
						"scott", "tiger");
			
				pstmt = con.prepareStatement(sql.toString());
				
				rs = pstmt.executeQuery();
				
				// 방명록의 저장된 값을 가져오는
				while(rs.next()) {
					int no = rs.getInt("no");
					String writer = rs.getString("writer");
					String memo = rs.getString("memo");
					java.sql.Date regdate = rs.getDate("regdate");
					
					
					//테이블을 만들어서 뿌린다.
					out.println("<table align = center width = 500 border = 1>");
					//테이블 안에  번호 작성자 날짜 등등을 뿌림
					out.println("<tr>");
					out.println("<th width =50>번호</th>");
					out.println("<td width =50 align = center>"+ no +"</td>");
					
					out.println("<th width =70>작성자</th>");
					out.println("<td width =180 align = center>"+ writer +"</td>");
					
					out.println("<th width =50>날짜</th>");
					out.println("<td width =100 align = center>"+ regdate +"</td>");
					//1번째 줄 끝
					out.println("</tr>");
					
					//2번째 줄
					out.println("<tr>");
					out.println("<th width =50>내용</th>");
					out.println("<td colspan = 5> &nbsp;"); //5칸을 합친다.
					out.println("<textarea rows = 3 cols = 50>"+ memo +"</textarea>");
					
					
					
					out.println("</td>");
					out.println("</tr>");
					
					out.println("</table>"); 
					out.println("<p>");
				}
				
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally { 
			try { if(rs != null)rs.close(); } catch(SQLException ss) {}
			try { if(pstmt != null)pstmt.close(); } catch(SQLException ss) {}
			try { if(con != null)con.close(); } catch(SQLException ss) {}
			}
			out.println("<p align = center>"
					+"<a href=/ServletProject/bbs/write.html>글쓰기</a>"
					+"</p>");
			out.println("</body>");
			out.println("</html>");
		}finally {
			out.close();
		}
		}
	}
	

