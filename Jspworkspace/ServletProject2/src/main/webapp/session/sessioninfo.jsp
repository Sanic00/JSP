<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page session = "true" %>  <!--  session 기본 디폴트값이 true이다. -->

<%@ page import ="java.util.Date" %>
<%@ page import ="java.text.SimpleDateFormat" %>


<%
	Date time = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보</title>
</head>
<body>
<!-- 세션 아이디를 가져오자 세션은 서버 쿠키는 브라우저  -->
세션 ID : <%= session.getId() %><br>
<%
	time.setTime(session.getCreationTime());
%>
							<!--지정  -->
세션 생성 시간 : <%=formatter.format(time)  %>

<%					/*마지막접속 시간  */
	time.setTime(session.getLastAccessedTime());
%>

가장 최근 접근시간:  <%=formatter.format(time)  %>
</body>
</html>