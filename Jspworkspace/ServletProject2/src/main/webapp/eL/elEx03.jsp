<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h3>EL(Expression language)</h3>
	<p>연산자를 사용 </p>
	
	<table border="1">
	<tr><td> <b>표현식</b>  </td><td> <b>값</b> </td></tr>
	<tr><td> <b>\${2+5}</b> </td><td> <b>${2+5}</b> </td></tr>
	<tr><td> <b>\${4/5}</b> </td><td> <b>${4/5}</b> </td></tr>
	<tr><td> <b>\${5 div}</b> </td><td> <b>${5 div 6}</b> </td></tr> <!--div 라는 태그가아닌 키워드로 연산이 사용가능  -->
	<tr><td> <b>\${5 mod 7}</b> </td><td> <b>${5 mod 7}</b> </td></tr> <!-- %연산자임 mod는 -->
	<tr><td> <b>\${5 lt 7}</b> </td><td> <b>${5 lt 7}</b> </td></tr><!-- lt 작다의 키워드  -->
	<tr><td> <b>\${5 gt 7}</b> </td><td> <b>${5 gt 7}</b> </td></tr><!-- gt 크다의 키워드  -->
	<tr><td> <b>\${(5>3)?5:3}</b> </td><td> <b>${(5>3)?5:3}</b> </td></tr><!-- 삼항연산자 -->
	
	
	
	</table>
	
</body>
</html>