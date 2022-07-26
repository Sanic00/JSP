<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<!--자바코드가 없어지기 때문에 쓰이는 고오급언어임 대부분2개만 사용  -->
<sql:query var="rs" dataSource="jdbc/myoracle">
select * from tempmember
</sql:query>

<table border="1">
	<tr><%--필드명 출력 ex)이름/pass/name.... --%>
		<c:forEach var="columnName" items="${rs.columnNames}">
			<th><c:out value="${columnName}"/></th>		
		</c:forEach>
	</tr>
	<%-- 레코드 수만큼 반복처리--%>
	<c:forEach var="row" items="${rs.rowsByIndex }">
	  <tr>
		  <%-- 레코드의 필드 수만큼 반복처리 2중 for문 --%>
		  	<c:forEach var="column" items="${row}" varStatus="i">
		  		<td>
		  			<!--해당 필드값이 null이 아니면  -->
		  			 <c:if test="${column != null}">
		  				<c:out value="${column}"/>			 
		  			 </c:if>
		  			 
		  			<!--해당 필드값이 null이면  -->
		  			 <c:if test="${column == null}">
		  				&nbsp;
		  			</c:if>

		  		</td>
		  	</c:forEach>
	  </tr>
	</c:forEach>
	
</table>



</body>
</html>