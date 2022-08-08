<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage = "/error/error.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 출력</title>
</head>
<body>



  <!-- 실행 주소 끝에 hong을 넣어봐라  파라미터 값으로 들어간다. -->
	name 파라미터  값:
	<%= request.getParameter("name").toUpperCase() %>
	

</body>
</html>