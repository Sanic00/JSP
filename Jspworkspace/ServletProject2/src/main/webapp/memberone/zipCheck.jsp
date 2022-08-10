<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src = "script.js"></script>
</head>
<body bgcolor="#FFFFCC">
<div align = "center">
<b>우편번호 찾기</b>
<!-- 자기자신한테 페이지를 뿌리겟다. -->
<form action="zipCheck.jsp" name ="zipForm" method="post">
	<table>
		<tr>
			<td>
				동이름 입력 : <input type="text" name = "dong">
				<input type="button" value = "검색" onclick="#">
			</td>
		</tr>
	</table>
</form>

<!-- 검색한 것을 여기다 뿌린다 -->
<table>
  	<tr>
  		<td align = "center">
  		<a href ="javascript:this.close()">닫기</a>
  		</td>
  	</tr>
</table>

</div>



</body>
</html>