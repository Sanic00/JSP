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
<body bgcolor="#FFFFCC">
<h2>JSP 스크립틀릿에서 데이터베이스 연동</h2>
<table bordercolor ="#0000FF" border="1">
<tr>
	<td><strog>ID</strog></td>
	<td><strog>PASSWD</strog></td>
	<td><strog>NAME</strog></td>
	<td><strog>MEM_NUM1</strog></td>
	<td><strog>MEM_NUM2</strog></td>
	<td><strog>E_MAIL</strog></td>
	<td><strog>PHONE</strog></td>
	<td><strog>ZIPCODE / ADDRESS</strog></td>
	<td><strog>JOB</strog></td>
</tr>

<!--DB에서 가져다가 옴-->
	<% 
	if(rs != null) {
		while(rs.next()){
			id = rs.getString("id");
			passwd = rs.getString("passwd");
			name = rs.getString("name");
			mem_num1 = rs.getString("mem_num1");
			mem_num2 = rs.getString("mem_num2");
			e_mail = rs.getString("e_mail");
			phone = rs.getString("phone");
			zipcode = rs.getString("zipcode");
			address = rs.getString("address");
			job = rs.getString("job");
	%>
	<!--Db에서 불러온 (저장) 데이터를 값을 출력 -->
	<tr>
	 <td><%= id %></td>
	 <td><%= passwd %></td>
	 <td><%= name %></td>
	 <td><%= mem_num1 %></td>
	 <td><%= mem_num2 %></td>
	 <td><%= e_mail %></td>
	 <td><%= phone %></td>
	 <td><%= zipcode %>/<%= address %></td>
	 <td><%= job %></td>


<%
	counter++;
		}//end of while
	}//end of if
%>
	</tr>
	
</table><br><br>
total records : <%= counter %>



<% } catch(SQLException ss){
	System.out.println("sql Exception.....");
	}catch (Exception e){
	System.out.println("sql Exception.....");
	}finally {
		if(rs != null) try{rs.close();}catch(SQLException s1){}
		if(stmt != null) try{stmt.close();}catch(SQLException s2){}
		if(conn != null) try{conn.close();}catch(SQLException s3){}
		
		
	}
	
%>

</body>
</html>