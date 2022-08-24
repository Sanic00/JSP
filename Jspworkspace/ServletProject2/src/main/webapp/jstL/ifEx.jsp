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
<c:if test = "${3>4 }">
조건이 false이면 화면에 나타나지 않습니다.
</c:if>

<c:if test = "${5>4 }">
조건이 true면 화면에 나타나네?
</c:if>

<c:if test = "${param.type eq'guest'}">
 홈페이지 방문을 무쟈게 확인하는 바입니다.<br>
 빠른 회원 가입을 하시기 바랍니다.<br>
</c:if>

<!--파라미터로 날려라   -->
<c:if test = "${param.type eq'member'}">
 회원님의 방문을 환영합니다.<br>
 즐거운 시간을 보내십시오.<br>
 보다 나은 서비스를 제공하기 위해서는 후원이 필요로 하니<br>
</c:if>

</body>
</html>