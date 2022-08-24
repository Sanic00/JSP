<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--태그 라이브러리를 임포트 해야된다.  -->
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
    
    <jsp:useBean id="vo" class="com.jstl.MemberVO" />
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!--홍길동이라는 값을 vo에다가 저장시킨다. property에 변수명 집어넣는다. -->
	<c:set target="${vo}" property="name" value="홍길동"/>
	<c:set target="${vo }" property="email">
	hong@naver.com
	</c:set>
	
	<c:set var="age" value="30"/> <!--var age 에 30을 미리 저장시킴  -->
	<c:set target="${vo}" property="age" value="${age}"/>

	<h3>회원정보</h3>
	<ul>
		<li>이름 :${vo.name}</li>
		<li>이메일 :${vo.email}</li>
		<li>나이 :${vo.age}</li>
	
	</ul>

</body>
</html>