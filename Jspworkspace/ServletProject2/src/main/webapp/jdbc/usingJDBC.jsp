<%@page import="java.sql.SQLException"%>
<%@page import = " java.sql.*" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <% 
  	Class.forName("oracle.jdbc.driver.OracleDriver");
  	Connection conn = null;
  	Statement stmt = null;
  	ResultSet rs = null;
  
  	String id="",
  			passwd="",
  			name="",
  			mem_num1="",
  			mem_num2="",
  			e_mail="",
  			phone="",
  			zipcode = "",
  			address = "",
  			job = "";
  			
  	int counter = 0;
  	 
  	try { 
  		
  		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
  		stmt = conn.createStatement();
  		rs = stmt.executeQuery("select*from tempmember");
  		
  		
  
  %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP에서 데이터베이스 연동</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h2>JSP 스크립틀릿에서 데이터베이스 연동</h2>
<table bordercolor ="#0000FF" border="1">
<tr>
	<td></td>
</tr>
</table><br><br>
total records : <%= counter %>



<% } catch(SQLException ss){
	System.out.println("sql Exception.....");
	}catch (Exception e){
	System.out.println("sql Exception.....");
	}finally {
		if(rs != null) try{rs.close();}catch(SQLException s1){}
		if(rs != null) try{rs.close();}catch(SQLException s2){}
		if(rs != null) try{rs.close();}catch(SQLException s3){}
		
		
	}
	
%>

</body>
</html>