<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클라이언트 및 서버 정보</title>
</head>
<body>
클라이언트의 IP를 알아보자 : <%=request.getRemoteAddr() %> <br> <br>
   요청정보의 길이를 알아보자  : <%=request.getContentLength() %> <br> <br>
   요청정보의 인코딩을 알아보자 : <%= request.getCharacterEncoding() %> <br> <br>
   요청정보의 컨텐트 타입을 알아보자 : <%=request.getContentType() %> <br> <br>
   요청정보의 프로토콜을 알아보자 : <%=request.getProtocol() %> <br> <br>
   요청정보의 전송방식을 알아보자 : <%=request.getMethod() %> <br> <br>
   요청 URL을 알아보자 :<%=request.getRequestURL().toString() %>  <br> <br>
   요청 URI을 알아보자 : <%=request.getRequestURI().toString() %> <br> <br>
   컨텍스트 경로를 알아보자 : <%=request.getContextPath() %> <br> <br>
   서버 이름을 알아보자 : <%=request.getServerName() %> <br> <br>
   서버 포트를 알아보자 : <%=request.getServerPort() %> <br> <br>


</body>
</html>