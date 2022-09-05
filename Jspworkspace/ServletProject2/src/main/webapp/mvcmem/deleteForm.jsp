<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>

</head>
<body onload = "begin()">
	  
	  <form action="member.mdo?cmd=deleteProc" method = "post" name= "myForm" onsubmit="return checkIt()">
	  	<table width ="260" border="1" align = "center"> 
	  		 <tr>
	  		 		<td colspan ="2" align = "center">
						<b>회원 탈퇴</b>	  		 		
	  		 		</td>
	  		 </tr>
	  		 
	  		 <tr>
	  		 	<td width = "150"><b>비밀번호 입력</b></td>
	  		 	<td width = "110">
	  		 	 <input type = "password" name = "pass" size ="15">
	  		 	</td>
	  		</tr>
	  		
	  		<tr>
	  			<td colspan = "2" align = "center">
	  				<input type ="submit" value = "회원탈퇴">
	  				<!--취소 버튼을 누르면 로그인 폼으로 이동  -->
	  				<input type ="button" value = "취소" onclick ="javascript:window.location='member.mdo?cmd=login'"> 	
	  			</td>
	  		</tr>
	  	
	  	</table> 
	  </form>	
	  
	  	
	  	
	  	
</body>
</html>