<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- jstl 사용을 위해  --> 
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복체크</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src = "script.js"></script>
</head>
<body bgcolor="#FFFFCC">
<br>
<div align = "center">
<!--el로   -->
<b>${id }</b>
	
	<c:if test="${check eq true }">
	는 이미 존재하는 ID입니다.<br><br>
	</c:if>
	
	<c:if test="${check ne true }">
	는 사용가능한 ID입니다.<br><br>
	</c:if>
	
	
						<!--자기자신을 닫는거라 self.close -->
	<a href = "#" onclick="javascript:self.close()">닫기</a>
</div>

</body>
</html>