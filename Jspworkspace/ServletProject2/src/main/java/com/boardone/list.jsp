<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.boardone.BoardDAO"%>
    <%@page import="com.boardone.BoardVO"%>
    <%@page import="java.util.List" %>
    <%@page import="java.text.SimpleDateFormat" %>
    <%@ include file = "view/color.jsp" %> 
    
    <!--심플 데이터의 객체 생성  -->
    <%!
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
    %>
    
  
    <%
    int count = 0;
   	int number =0;
   	List<BoardVO> articleList = null;
   	BoardDAO dbPro = BoardDAO.getInstance(); // db연결
   	
 	count = dbPro.getArticleCount(); //전체글수를 가져옴
	if(count > 0){ //글이 있다면
	articleList = dbPro.getArticles();
	}
 	
 	number = count;
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body bgcolor = "<%= bodyback_c%>">

<div align ="center"><b>글 목록(전체 글 :<%= count%>)</b>
	
<table width ="700">
	<tr>
		<td align ="right" bgcolor = "<%= value_c %>">
			<a href ="writeForm.jsp">글쓰기</a>
		</td>
	</tr>
</table>	

	<% if(count == 0) {%> 
	
<table width ="700" border = "1" cellpadding ="0" cellspacing = "0"> 
	<tr>
		<td align ="center">
			게시판에 저장된 글이 없습니다.
		</td>
	</tr>
</table>
	
<% } else { %>

<table width ="700" border = "1" cellpadding ="0" cellspacing = "0" align = "center">
		<tr height = "30" bgcolor ="<%=value_c %>">
			<td align ="center" witdh="50">번호</td>
			<td align ="center" witdh="250">제목</td>
			<td align ="center" witdh="100">작성자</td>
			<td align ="center" witdh="150">작성일</td>
			<td align ="center" witdh="50">조회수</td>
			<td align ="center" witdh="100">IP</td>
	</tr>
	
<% 
	//article리스트 뿌려야된다 
	for(int i =0; i<articleList.size(); i++){
	BoardVO article = (BoardVO)articleList.get(i);
	
%>	
<tr height = "30">					<!--내림차순으로 출력하기 위해 -- 연산자  -->
	<td align = "center" width ="50"> <%= number-- %></td>
	<!-- 제목을 눌렀을때 글의 내용이 보이도록 연결 시켜줘아댜된다 -->
	<td width ="250">
	<a href = "content.jsp?num=<%= article.getNum() %>&pageNum = 1">
	<%= article.getSubject() %></a>
	<% if(article.getReadcount() >= 20){ %> <!-- 조회수가 20번이상 때 이미지 삽입 -->
	<img src="img/hot.gif" border = "0" height = "16">
	<% } %>
	
	</td>
	<td align = "center" width ="100">
	<a href = "mailto: <%= article.getEmail() %>">
	<%= article.getWriter() %></a>
	</td>
	
	<td align ="center" witdh="150">
	<%= sdf.format(article.getRegdate()) %>
	</td>
	
	<td align ="center" witdh="50"><%= article.getReadcount() %></td>
	
	<td align ="center" witdh="100"><%= article.getIp() %></td>
	
	
			
	
	
<% } //end for문 %>	

</table> 

<% } // end else문 %>

</div>

</body>
</html>