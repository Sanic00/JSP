<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "java.net.URLEncoder" %>
    
    <%
     						  //이름	//쿠키 값을 encode를 통해 압축형태로 나옴	디코드는 해제
  	Cookie cookie = new Cookie("name",URLEncoder.encode("홍길동","UTF-8"));  
    
    response.addCookie(cookie);
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠기 생성</title>
</head>
<body>
	<%= cookie.getName() %> 쿠키의 값 <%= cookie.getValue() %>
	
</body>
</html>