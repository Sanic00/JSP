<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 	session.invalidate();
%>    
    

  <script type ="text/javascript">
  alert("세션이 끊겨서 로그아웃됬음!");
  location.href="cookieMemberLogin.jsp";
  </script>