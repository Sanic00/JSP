
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  
  <%
  HashMap<String, Object> mapData = new HashMap<String, Object>();
  Date today = new Date();
  mapData.put("name", "홍길동");
  mapData.put("today", new java.util.Date());
 
  %> 
  
  <c:set var="intArray" value ="<%=new int[]{1,2,3,4,5,6} %>"/>
  <c:set var="map" value = "<%=mapData %>"/>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<!--1부터 100까지의 홀수의 합  -->
<h4>1부터 100까지의 홀수의 합</h4>
<c:set var="sum" value="0"/>
<c:forEach var="i" begin="1" end="100" step="2">
  <c:set var="sum" value="${sum+i}"/>

</c:forEach>

결과 : ${sum }<br>

<br>

<h4>구구단 4단</h4>
<ul>
	<c:forEach var="i" begin="1" end="9"> 
	<li>4 * ${i}= ${4*i }</li>
	</c:forEach>
</ul>
<br>

<h4>int형 배열</h4>
<c:forEach var="i" items="${intArray}" begin="2" end="4">
${i}
</c:forEach>
<br>
<h4>Map</h4>
<c:forEach var="i" items="${map}">
${i.key} =${i.value}<br>

</c:forEach>

</body>
</html>