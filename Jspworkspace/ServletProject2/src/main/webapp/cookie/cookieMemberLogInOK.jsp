<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ page import = "com.logon.cookie.LoginDBBean" %>
    <% request.setCharacterEncoding("utf-8"); %>
    
    <%
		//아이디랑 패스워드를 가져와야된다. 메소드의 매개변수로 넘겨준다    
    	String id = request.getParameter("id");
    	String passwd = request.getParameter("passwd");
		
    	LoginDBBean manager = LoginDBBean.getInstance();
    	
    	
    	
		int check = manager.userCheck(id, passwd);
     
		if(check == 1){ //로그인 성공
			
		  Cookie cookie = new Cookie("memId",id);
		  cookie.setMaxAge(60*60);
		  response.addCookie(cookie);
		  response.sendRedirect("cookieLogInConfirm.jsp");
		
		}else if (check == 0) { // 아이디는 존재하는데 비밀번호가 오류일때
			
    %>
    <script type="text/javascript">
		alert("비밀번호가 틀렸습니다.");
		history.go(-1); // 바로 이전페이지로 
</script>
    <% } else { //아이디가 존재 하지 않을때 %>
     <script type="text/javascript">
		alert("아이디가 존재하지않습니다.");
		history.go(-1); // 바로 이전페이지로 
</script>

 <% } %>
