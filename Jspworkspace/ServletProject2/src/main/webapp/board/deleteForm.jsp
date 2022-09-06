<%@page import="org.apache.el.parser.AstDiv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ include file="view/color.jsp" %>
    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 삭제</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src = "script.js"></script>
</head>
<body bgcolor="${bodycheck_c }">

<div align = "center"><b>글삭제</b>
<br><br>

<form action="/ServletProject2/board/deletePro.bdo?pageNum=${pageNum}" method = "post" name="delForm" onclick = "return deleteSave()">
	<table width="360" border ="1" align = "center" cellpadding ="0" cellspacing="0">
		<tr height = "30">
			<td bgcolor="${value_c }" align = "center">
				<b>비밀번호를 입력해주세요</b>
			</td>
		</tr>
	
	 <tr height="30">
	 	<td align="center"> 비밀번호:
	 		<input type="password" name ="pass" maxlength="12">
	 		<input type ="hidden" name="num" value="${num }">
	 	</td>
	 </tr>
	 
	  <tr height="30">
	  	<td align = "center">
	  			<input type="submit" value = "글삭제">
	  			<input type = "button" value="글 목록" 
	  			onclick = "document.location.href = '/ServletProject2/board/list.bdo?pageNum=${pageNum}'">
	  			
	  	</td>
	  </tr>
	 
	</table>



</form>
</div>

</body>
</html>