<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="com.memberone.*" %>
    
    <jsp:useBean id ="dao" class ="com.memberone.StudentDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
<!-- 이 페이지는 리턴값을 받고 처리하는 페이지 -->
 <!-- 폼안에 있는걸 db에서   -->
	<% 
	
		String id  = (String)session.getAttribute("loginID");
		String pass = request.getParameter("pass");
		
		//dao 메소드 호출
		int check = dao.deleteMember(id, pass);
			if(check ==1) {
				session.invalidate();			
				
	%>

<meta http-equiv ="Refresh" content = "0; url=login.jsp"> <!-- 여기부분으로 바로 이동 가능 숫자3을 0으로 하면 0초 -->
<body>
 <div align="center">
 <font size = "5" face="궁서체">
    <b>회원탈퇴가 되셨습니다</b><br>
   	 잘가 ~ 
  </font>
 </div>
 
 <% }else { %>
   <script type = "text/javascript">
   alert("비밀번호가 맞지 않습니다.");
   history.go(-1);
   </script>
 <% } %>
</body>
</html>