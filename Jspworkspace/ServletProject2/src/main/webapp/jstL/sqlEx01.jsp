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
</table>



</body>
</html>