<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <fmt:requestEncoding value = "utf-8"/> <!--한글이 깨질때 쓰면됨  -->
 
 
 <!--영어로 설정할땐 이렇게 주석처리하면 한글로 나옴 기본 브라우저 설정이 지금 한국어로 되어있어서그럼  -->
<%--  <fmt:setLocale value="en"/> --%>
 <!--영문부터  -->
 <fmt:bundle basename="bundle.testBundle">
 <fmt:message key="TITLE" var="title" /> <!--이게 html title로 간다  -->
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
</head>
<body>
<fmt:message key="NAME"/>
<br>
<c:if test="${! empty param.id}">
	<fmt:message key="MESSAGE">
	<fmt:param value="${param.id}"/>
	</fmt:message>
</c:if>

</body>
</html>
</fmt:bundle>