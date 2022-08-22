<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload Form</title>
</head>
<body>
<!--여러개를 한꺼번에 업로드 할려면 배열로 해서 뿌린다함 (잘따라와야됨 무지하게 어려움)  -->

<div align = "center">                           <!--이 인코딩 압축형태가 빠지면 안된다.-->         
	<form action="fileUpload.jsp"  method="post" enctype="multipart/form-data">
		<table border="1">
		 <tr>
		 	<td colspan="2" align="center"><h3>파일 업로드 폼</h3></td>
		 </tr>
		 
		 <tr>
		 	<td>올린 사람 :</td><td> <input type="text" name="name"></td>
		 </tr>
		 
		 <tr>
		 	<td>제목 :</td><td> <input type="text" name="subject"></td>
		 </tr>
		 
		 <tr>
		 	<td>파일명1 :</td><td> <input type="file" name="fileName1"></td>
		 </tr>
		 
		 <tr>
		 	<td>파일명2 :</td><td> <input type="file" name="fileName2"></td>
		 </tr>
		 
		 <tr>
		 	<td colspan="2" align="center">
		 		<input type="submit" name="파일업로드">
		 		</td>
		  </tr>
		 
		</table>
		
	</form>
</div>


</body>
</html>