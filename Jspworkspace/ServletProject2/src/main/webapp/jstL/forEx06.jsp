<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>																	<!--구분자-->			
<c:forTokens var="token" items="빨강맛,주황맛.노랑맛,퍼렁맛.남맛,보라맛" delims=",.">
${token};<br>



</c:forTokens>

</body>
</html>