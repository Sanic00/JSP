<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>썸 네일이미지폼(장바구니에 이미지)</title>
</head>
<body>
<div align ="center">
<h3>썸네일 이미지 폼</h3>
<!-- thumbnail로 보내겠다. -->
<form action="thumbnail.jsp" method ="post" enctype="multipart/form-data">

이미지 파일 :<input type ="file" name="filename"><br>
			 <input type ="submit" value="전송">

</form>				
</div>

</body>
</html>