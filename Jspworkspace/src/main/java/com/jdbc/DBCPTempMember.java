package com.jdbc;

import java.sql.*;
import java.util.*;
import com.jdbc.*;
import java.sql.Connection; 
import javax.sql.DataSource; 
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;


public class DBCPTempMember {
	
	DataSource ds;
	
	public DBCPTempMember() {
		try {

			 Context initContext = new InitialContext();								 
			 ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
		}catch(NamingException ne) {
			ne.printStackTrace();
		}
	}
	
	
	public Vector<TempMemberVO> getMemberList(){
		Connection conn = null;
	  	Statement stmt = null;
	  	ResultSet rs = null;
		
	  	Vector<TempMemberVO> vecList = new	Vector<TempMemberVO>();
	  	
	  	try {
	  		//DBCP로 할때 밑에 구문은 바껴야된다.
	  		conn = ds.getConnection();
	  		
	  		String strQuery = "select * from tempmember";
	  		
	  		stmt = conn.createStatement();
	  		rs = stmt.executeQuery(strQuery);
	  		
	  		//뿌리기
	  		while(rs.next()){
	  			TempMemberVO vo = new TempMemberVO();
	  			vo.setId(rs.getString("id"));
	  			vo.setPasswd(rs.getString("passwd"));
	  			vo.setName(rs.getString("name"));
	  			vo.setMem_num1(rs.getString("mem_num1"));
	  			vo.setMem_num2(rs.getString("mem_num2"));
	  			vo.setE_mail(rs.getString("e_mail"));
	  			vo.setPhone(rs.getString("phone"));
	  			vo.setZipcode(rs.getString("zipcode"));
	  			vo.setAddress(rs.getString("address"));
	  			vo.setJob(rs.getString("job"));

	  			
	  			vecList.add(vo);
	  		}
	  		
	  	} catch(SQLException ss){
	  		System.out.println("sql Exception.....");
		}catch (Exception e){
		System.out.println("sql Exception.....");
		}finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(stmt != null) try{stmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}	
		}
	
	  	return vecList;
	  	
	}
}
