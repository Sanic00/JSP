<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 이건 앞으로 계속 쓰임 -->
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
     
     <c:import url="/sample/First.jsp" var="url"/>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<!--url으로 뷰로 뿌림  -->
${url}

</body>
</html>