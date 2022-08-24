<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//이것을 EL로 출력
     	request.setAttribute("name", "홍길동");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request의 name속성</title>
</head>
<body>
	<!--파라미터 던지는 법 주소창에 ? 바인딩으로 해서 던질수 있따.  -->
	request의 name속성: ${requestScope.name} <br>
	code 파라미터 : ${param.code }<br><br>
	

	
</body>
</html>