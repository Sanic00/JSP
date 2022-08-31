<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="com.boardone.BoardDAO"%>
    <%@page import="java.sql.Timestamp"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    
    <jsp:useBean id ="article" class="com.boardone.BoardVO" scope="page">
    <jsp:setProperty name ="article" property="*"/>
    </jsp:useBean>
    
    <%
    //deleteform 에서 hideen으로 해서 가져옴
    int num = Integer.parseInt(request.getParameter("num"));
    String pageNum = request.getParameter("pageNum");
    
    //pass deleteform 패스에 가져온다.
    String pass = request.getParameter("pass");
    BoardDAO dbPro = BoardDAO.getInstance();
    	
    int check = dbPro.deleteArticle(num, pass);
    
    if(check == 1){ //삭제 성공
    
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
		alert("삭제 실패");
		history.go(-1);
		</script>
	<% } %>	

</body>
</html>