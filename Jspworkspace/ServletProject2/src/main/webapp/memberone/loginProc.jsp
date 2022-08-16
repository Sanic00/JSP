<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id ="dao" class ="com.memberone.StudentDAO"/>
    
    
    <%
		//아이디랑 패스워드를 가져와야된다. 메소드의 매개변수로 넘겨준다    
    	String id = request.getParameter("id");
    	String pass = request.getParameter("pass");
		
		int check = dao.loginCheck(id, pass);
     
		if(check == 1){ //로그인 성공
			//내장객체 세션이라는 개체가 속성값을 저장합니다.
		  session.setAttribute("loginID", id);
		//강제로 보낸다  
		response.sendRedirect("login.jsp");
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
