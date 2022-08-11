<%@page import="com.memberone.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
   <%@ page import= "com.memberone.ZipCodeVO" %>
   <%@ page import= "java.util.Vector" %>
    
    <%-- DAO 객체 생성 --%>
    <jsp:useBean id ="dao" class="com.memberone.StudentDAO" />
    
    <%
      request.setCharacterEncoding("UTF-8");
    	
    //자바스크립트에서 2개의 파라미터가 넘어와야된다. 스크립트가 y(yes) 일때 검색이 된다.
      String check = request.getParameter("check");
      String dong = request.getParameter("dong"); //검색을 동으로 한다.
    
      // 파라미터 값을 zipcodeRead() 메소드의 매개변수로 전달
       Vector<ZipCodeVO> zipcodeList = dao.zipcodeRead(dong);
      
       int totalList = zipcodeList.size();
       System.out.println("검색 개수"+ totalList);
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body bgcolor="#FFFFCC">
<div align = "center">
<b>우편번호 찾기</b>
<!-- 자기자신한테 페이지를 뿌리겟다. -->
<form action="zipCheck.jsp" name ="zipForm" method="post">
	<table>
		<tr>
			<td>
				동이름 입력 : <input type="text" name = "dong">
				<input type="button" value = "검색" onclick="dongCheck()">
			</td>
		</tr>
	</table>


<!-- 검색한 것을 여기다 뿌린다 -->
<table>
  	<tr>
  		<td align = "center">
  		<a href ="javascript:this.close()">닫기</a>
  		</td>
  	</tr>
</table>
	<input type = "hidden" name = "check" value = "n">

</form>
<!--동 검색한 결과를 테이블로 뿌린다  -->
<table> 
<%
 	if(check.equals("n")){
 		
%>
<!--검색 결과가 없을때  -->
 	<%
  		if(zipcodeList.isEmpty()){
	 %>
	<tr><td align = "center"><br>검색된 결과가 없습니다.</td></tr>
	
 <!-- 결과가 있을때-->
 <% } 
 	else 
 	{
 %>
	<tr><td align = "center"><br>
	※ 검색 후, 아래 우편번호를 클릭하여 자동으로 주소가 입력됩니다.</td></tr>
 
     <%
     for(int i =0; i<totalList; i++){
    	 ZipCodeVO vo = zipcodeList.elementAt(i); // 값을 가져오게한다
    	 
    	 String tempZipcode = vo.getZipcode();
    	 String tempSido = vo.getSido();
    	 String tempGugun = vo.getGugun();
    	 String tempDong = vo.getDong();
    	 String tempRi = vo.getRi();
    	 String tempBunji = vo.getBunji();
    	 
    	   if(tempRi == null) tempRi = "";
    	   if(tempBunji == null)tempBunji = "";
    	 
     %>
     
     <tr><td>
     <a href ="javascript:sendAddress('<%=tempZipcode%>','<%=tempSido%>','<%=tempGugun%>','<%=tempDong%>','<%=tempRi%>','<%=tempBunji%>')">
     <%=tempZipcode%>&nbsp;<%=tempSido%>&nbsp;<%=tempGugun%>&nbsp;<%=tempDong%>&nbsp;<%=tempRi%>&nbsp;<%=tempBunji%>
     </a>
     <br> 
	<%
     	} //end for
 	} //end of else
  }//end of if
	%>
</td></tr>
	<tr>
		<td align = "center">
		<a href="javascript:this.close()">닫기</a>
		</td>
	</tr>

</table>






</div>


<script type="text/javascript" src = "script.js"></script>
</body>
</html>