<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //pageContext Scope에 속성 값 저장하기 (해당 JSP 페이지 내에서만 유효)
    pageContext.setAttribute("pageAttribute", "길동 홍");
    
    //이렇게도 가능                                         페이지수를 지정 페이지수 범위는 생략가능
   /*  pageContext.setAttribute("pageAttribute", "길동 홍", PageContext.PAGE_SCOPE); */
    
   // request Scope 에 속성 저장하기 (client request 객체가 유지되는 동안만 유효성을 가짐)
   // 즉 모델에서 뷰로 전달해줄때 사용
   request.setAttribute("requestAttribute", "010-1234-1234");
   																//범위는 로그인에서부터 로그아웃까지
   /*  pageContext.setAttribute("requestAttribute", "010-1234-1234", PageContext.REQUEST_SCOPE); */
   
   // session Scope 속성 저장하기 
   session.setAttribute("sessionAttribute", "hong@naver.com");
   /*  pageContext.setAttribute("sessionAttribute", "hong@naver.com", PageContext.SESSION_SCOPE); */
   
   // application Scope 속성 저장하기 
   application.setAttribute("applicationAttribute", "Global In(주)");
   /*  pageContext.setAttribute("applicationAttribute", "Global In(주)", PageContext.APPLICATION_SCOPE); */
   
   %>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<ul>

<li> 이름 : <%=pageContext.getAttribute("pageAttribute") %></li>
<li> 전화번호 : <%=request.getAttribute("requestAttribute") %></li>
<li> 메일 : <%=session.getAttribute("sessionAttribute") %></li>
<li> 회사 : <%=application.getAttribute("applicationAttribute") %></li>

</ul>
<!--자바의 VO GETTER SETTER 와 같음  -->
<%-- <jsp:useBean id="빈의 이름" scope="유효범위" class="빈의 저장위치"/>
   id : 객체를 식별하는 이름 (인스턴스) 
scope : 객체의 참조 유효 범위를 의미함(기본 범위 : page) ex)page인지 어플리케이션인지  
class : 완전한 형태의 클래스 이름 --%>
</body>
</html>