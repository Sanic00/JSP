<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import= "java.net.URLDecoder" %> <!--인코더의 반대 디코더 압축을 해제하는 역할을 한다. -->
      
      
      
      
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 목록 뿌리기</title>
</head>
<body>
	<br>
	
	<%
		Cookie[] cookies = request.getCookies();  //쿠키값을 가져와서 배열에 저장
		
		if(cookies != null && cookies.length > 0){
			for(int i=0; i<cookies.length; i++){
	%>		
			<%= cookies[i].getName() %> =
			<%=URLDecoder.decode(cookies[i].getValue(), "utf-8") %>	<br>
	<% 	
			}
		}else{
	%>
	
	
	쿠키가 존재하지 않습니다
	<% } %>
</body>
</html>