<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.elEx.Customer, java.util.HashMap" %>
    
    <%
    Customer customer = new Customer();
    customer.setName("홍길동");
    customer.setEmail("hong123@naver.com");
    customer.setPhone("123-1234-1234");
    								//객체명				
    request.setAttribute("customer", customer);
    
    	//키 					
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("name", "소나타");
    map.put("maker", "현다이");
    
    				//속성의이름
    request.setAttribute("car", map);
 
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>

<ul>
<li>이름: ${customer.name}</li>
<li>메일: ${customer.email}</li>
<li>번호: ${customer.phone}</li>
<br><br>

</ul>
<ul></ul>
<!--hash를 사용해서 출력 -->
<li>자동차: ${car.name}</li>
<li>제조사: ${car.maker}</li>
<br><br>
</ul>

<!--자바 빈즈를 이용해서 출력 -->
<%= customer.getName() %><br>
<%= customer.getEmail() %><br>
<%= customer.getPhone() %><br>

</body>
</html>