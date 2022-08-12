<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id ="dao" class="com.memberone.StudentDAO" />
    <jsp:useBean id ="vo" class="com.memberone.StudentVO" />
    <!--vo자바파일에 있는 setter   -->
    <jsp:setProperty property ="*" name="vo"/>
    
    <!--데이터 베이스를 불러온다 setter로 처리 -->
  	<%
  		boolean flag = dao.memberInsert(vo);
  	
  	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 확인</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body bgcolor= "#ffffcc">
<br><br>
<div ailgn="center">

	<%
	if(flag) {
		out.println("<b>회원가입을 진심으로 축하 드립니다.<b><br>");
		//회원가입 성공후 로그인페이지로 이동하게
		out.println("<a href=login.jsp>로그인</a>");
	}else {
		out.println("<b>다시 입력하여 주십시오.<b><br>");
		//다시 가입 시키게 한다.
		out.println("<a href=regForm.jsp>로그인</a>");
	}
	
	%>
</div>
</body>
</html>