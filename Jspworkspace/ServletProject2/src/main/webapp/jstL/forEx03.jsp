
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<!-- begin 시작 end 얼마까지  step은 증가 또는 마이너스 varStatus 루프 횟수(el변수)-->
<c:forEach begin="1" end = "10" step = "1" varStatus="num">
<!--count 하나씩 증가  -->
${num.count }&nbsp;&nbsp;
</c:forEach>
<br>
					<!--step에선 마이너스 값이 허용되지않아서(float값도 안댐 양의 정수값만 가능) 증가되기만 가능  -->
<c:forEach begin="1" end = "10" step = "2" varStatus="num">
<!--count 하나씩 증가  -->
${num.count }&nbsp;&nbsp;
</c:forEach>



</body>
</html>