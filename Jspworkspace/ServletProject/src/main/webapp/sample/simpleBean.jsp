<%@page import="com.sample.SimpleData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
    		<!-- 밑에 객체 생성 과 똑같은거임 -->
   <jsp:useBean id="msg" class="com.sample.SimpleData" />
    
   <%--  <%
    SimpleData msg = new SimpleData();
    %> --%>
    
    		<!-- 자바클래스 여긴변수명     객체이름 -->		
    <jsp:setProperty property="message" name="msg"/>
    
   <%--  <% msg.setMessage("") %> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	
</body>
</html>