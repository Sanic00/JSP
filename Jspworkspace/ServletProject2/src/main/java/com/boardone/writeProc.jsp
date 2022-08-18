<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@page import="com.boardone.BoardDAO"%>
	<%@page import="java.sql.Timestamp"%>
	<% request.setCharacterEncoding("UTF-8");%>
	<jsp:useBean id="article" class ="com.boardone.BoardVO" scope = "page">
	
	<jsp:setProperty name ="article" property ="*" /> 
	
	</jsp:useBean>
	
	<%
	article.setRegdate(new Timestamp(System.currentTimeMillis())); //시스템의 현재시간을 매개변수로
	article.setIp(request.getRemoteAddr()); //본인의 현재 ip를 가져온다.
	
	BoardDAO dbPro = BoardDAO.getInstance(); //db연결
	dbPro.insertArticle(article);
	
	//강제로 넘기기
	response.sendRedirect("list.jsp"); 
	
	%>