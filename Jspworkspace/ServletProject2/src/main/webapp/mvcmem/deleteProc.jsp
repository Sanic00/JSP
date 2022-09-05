<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<meta http-equiv ="Refresh" content = "0; url=member.mdo?cmd=login"> <!-- 여기부분으로 바로 이동 가능 숫자3을 0으로 하면 0초 -->
<body>

<c:set var="result" value="${result}"/>

<div align="center">
	<c:if test="${result eq 0}"> 
	<script type = "text/javascript">
  	 alert("비밀번호가 맞지 않습니다.");
   	history.go(-1);
   	</script>
	</c:if> 
  
 <font size = "5" face="궁서체">
    <b>회원탈퇴가 되셨습니다</b><br>
   	 잘가 ~ 
  </font>
 </div>

</body>
</html>