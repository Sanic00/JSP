<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ include file = "color.jsp" %> 
   
   <%
   		String id ="";
   
   		try { 
   			//쿠키 배열로 가져온다 
   			Cookie[] cookies = request.getCookies();
   			
   			if(cookies != null) {
   				
   				for(int i=0; i < cookies.length; i++) {
   					if(cookies[i].getName().equals("memId")){
   						id = cookies[i].getValue();
   					}
   				}
   				if(id.equals("")){ //id값이 아무것도 안들어올때 로그인창으로 보낸다.
   					response.sendRedirect("cookieMemberLogIn.jsp");
   				}
   			
   			}else {
   				response.sendRedirect("cookieMemberLogIn.jsp");
   			}
   			
   		}catch(Exception e) {}
   			
   		
   
   %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 사용한 회원 인증</title>
<link href = "style.css" rel = "stylesheet" type ="text/css">
</head>
<body bgcololor ="<%= bodyback_c%>">
<form action="cookieMemberLogOut.jsp" method="post">
	<table width = "300" border = "1" align = "center">
			<tr>
				<td align="center"  bgcolor="<%=value_c%>">
				<b><%=id %></b>님이 로그인 하셨습니다.</td>
				
			</tr>
			
			<tr>
				<td align="center"  bgcolor="<%=value_c%>">
				<input type = "submit" value = "로그아웃">
				</td>				
			</tr>
				
				
	</table>
</form>
	
</body>
</html>