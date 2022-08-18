<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <%@ include file = "view/color.jsp" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Board 나의 게시판</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src = "script.js"></script>

</head>

<!-- 지금 작성하는 것이 새 글인지  답변 글인지 구분 해야된다. 새글일때 0번부터 시작 -->

<% 
	//새 글일 경우 num = 0 이라고 해서 넘겨줄 것이고 답변 글일 경우 원래의 글 번호의 num을 받아와서 
	// 넘겨준다 num을 통해서 새글인지 답변 글인지를 구별 할 수 있음
	int num =0, ref = 1, step =0, depth = 0;
	try {
	
		if(request.getParameter("num")!= null){
			//getParameter는 String 타입이라 정수형으로 형변환 해서 저장
			num = Integer.parseInt(request.getParameter("num"));
			ref	= Integer.parseInt(request.getParameter("ref"));
			step = Integer.parseInt(request.getParameter("step"));
			depth = Integer.parseInt(request.getParameter("depth"));
			
		}
	
%>






<body bgcolor = "<%= bodyback_c%>"> <!--color.jsp지정한 걸 씀 위에 include가 되야됨  -->

<div align = "center"><b>글 쓰기</b><br><br>
	<form action = "writeProc.jsp" method ="post" name = "writeForm" onsubmit="return writeSave()">
	<!--폼안에 넘겨줘야 됨  -->
	<input type = "hidden" name ="num" value ="<%= num %>">	
	<input type = "hidden" name ="ref" value ="<%= ref %>">	
	<input type = "hidden" name ="step" value ="<%= step %>">	
	<input type = "hidden" name ="depth" value ="<%= depth %>">	
	
		<table width = "400" border = "1" cellpadding ="0" cellspacing = "0" align = "center"
		align = "center" bgcolor ="<%= bodyback_c%>">
		 	<tr>
		 		<td align="right" colspan ="2" bgcolor="<%= value_c%>">
		 				<a href="list.jsp">글 목록</a>
		 		</td>
		 	</tr>
		
			<tr>
		 		<td width="70" bgcolor ="<%=value_c %>" align="center">이름</td>
		 		<td width = "330">
		 			<input type ="text" size="12" maxlength="12" name="writer">
		 		</td>
		 	</tr>
		
			<tr>
		 		<td width="70" bgcolor ="<%=value_c %>" align="center">이메일</td>
		 		<td width = "330">
		 			<input type ="text" size="30" maxlength="30" name="email">
		 		</td>
		 	</tr>
		
		<!-- 제목에서 새글인지 원래 있는 글인지   -->
			<tr>
		 		<td width="70" bgcolor ="<%=value_c %>" align="center">제목</td>
		 		<td width = "330">
		 		<% if(request.getParameter("num") == null){// 넘이 없을때는 0이니깐 새글임 %>	
		 			<input type ="text" size="50" maxlength="50" name="subject">
		 			<% } else {  //답변글%>
		 			<input type ="text" size="50" maxlength="50" name="subject" value = "[답변]">
		 			<%} %>
		 		</td>
		 	</tr>
		
			<tr>
		 		<td width="70" bgcolor ="<%=value_c %>" align="center">내용</td>
		 		<td width = "330">
		 			<textarea rows ="13" cols ="50" name ="content"></textarea>
		 		</td>
		 	</tr>
		
			<tr>
		 		<td width="70" bgcolor ="<%=value_c %>" align="center">비밀번호</td>
		 		<td width = "330">
		 			<input type ="password" size="10" maxlength="10" name="pass">
		 		</td>
		 	</tr>
		
			<tr>			
				<td colspan="2" bgcolor ="<%=value_c %>" align = "center">
					<input type = "submit" value ="글쓰기"><!-- 글쓰기를 눌루면 writeProc로 넘어가서 처리함 -->
					<input type = "reset" value ="다시작성">
					<input type = "button" value ="목록" onclick="window.location ='list.jsp'">
				</td>
			</tr>
		
		</table>
	</form>


</div>
<!--catch 앞 괄호가 try 괄호임  -->
<%} catch(Exception e){} %>


</body>
</html>