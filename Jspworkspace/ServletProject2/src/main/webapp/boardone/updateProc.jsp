<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@page import="com.boardone.BoardDAO"%>
    <%@page import="java.sql.Timestamp"%>
    
    
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id ="article" class="com.boardone.BoardVO" scope="page">
    <jsp:setProperty name ="article" property="*"/>
    </jsp:useBean>
    <%
    
    String pageNum = request.getParameter("pagenum");
    BoardDAO dbPro = BoardDAO.getInstance();
    
    int check = dbPro.updateArticle(article);
    
    if(check ==1){
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<meta http-equiv ="Refresh" content="3;url=list.jsp?pageNum=<%=pageNum %>">
<body>


	<%} else {%>
		<script type ="text/javascript">
		alert("비밀번호가 맞지 않습니다.");
		history.go(-1);
		</script>
	<% } %>	




</body>
</html>