<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    // 세션을 무효화 시킨다 (끊는거임)
    session.invalidate(); 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<font size ="5" face="궁서체">
	성공적으로 로그아웃 되었습니다.<br><br>
	<a href = "login.jsp"> 로그인페이지로 이동</a> 
	</font>	
</body>
</html>