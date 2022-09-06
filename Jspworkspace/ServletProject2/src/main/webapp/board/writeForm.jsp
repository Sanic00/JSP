<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  	
    <%@ include file = "view/color.jsp" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Board 나의 게시판</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src = "script.js"></script>

</head>

<body bgcolor = "${bodyback_c }"> <!--color.jsp지정한 걸 씀 위에 include가 되야됨  -->

<div align = "center"><b>글 쓰기</b><br><br>
	<form action = "/ServletProject2/board/writePro.bdo" method ="post" name = "writeForm" onsubmit="return writeSave()">
	<!--폼안에 넘겨줘야 됨  -->
	<input type = "hidden" name ="num" value ="${num }">	
	<input type = "hidden" name ="ref" value ="${ref }">	
	<input type = "hidden" name ="step" value ="${step }">	
	<input type = "hidden" name ="depth" value ="${depth }">	
	
		<table width = "400" border = "1" cellpadding ="0" cellspacing = "0" align = "center"
		align = "center" bgcolor ="${bodyback_c}">
		 	<tr>
		 		<td align="right" colspan ="2" bgcolor="${value_c }">
		 				<a href="/ServletProject2/board/list.bdo">글 목록</a>
		 		</td>
		 	</tr>
		
			<tr>
		 		<td width="70" bgcolor ="${value_c }" align="center">이름</td>
		 		<td width = "330">
		 			<input type ="text" size="12" maxlength="12" name="writer">
		 		</td>
		 	</tr>
		
			<tr>
		 		<td width="70" bgcolor ="${value_c }" align="center">이메일</td>
		 		<td width = "330">
		 			<input type ="text" size="30" maxlength="30" name="email">
		 		</td>
		 	</tr>
		
		<!-- 제목에서 새글인지 원래 있는 글인지   -->
			<tr>
		 		<td width="70" bgcolor ="${value_c }" align="center">제목</td>
		 		<td width = "330">
		 		<%--새글일 경우 --%>
		 		<c:if test="${num == 0 }">
		 			<input type ="text" size="50" maxlength="50" name="subject">
		 		</c:if>
		 		
		 		<%--답변글일 경우 --%>
		 		<c:if test="${num != 0 }">
		 			<input type ="text" size="50" maxlength="50" name="subject" value = "[답변]">
		 		</c:if>
		 		</td>
		 	</tr>
		
			<tr>
		 		<td width="70" bgcolor ="${value_c }" align="center">내용</td>
		 		<td width = "330">
		 			<textarea rows ="13" cols ="50" name ="content"></textarea>
		 		</td>
		 	</tr>
		
			<tr>
		 		<td width="70" bgcolor ="${value_c }" align="center">비밀번호</td>
		 		<td width = "330">
		 			<input type ="password" size="10" maxlength="10" name="pass">
		 		</td>
		 	</tr>
		
			<tr>			
				<td colspan="2" bgcolor ="${value_c }" align = "center">
					<input type = "submit" value ="글쓰기"><!-- 글쓰기를 눌루면 writeProc로 넘어가서 처리함 -->
					<input type = "reset" value ="다시작성">
					<input type = "button" value ="목록" onclick="window.location ='/ServletProject2/board/list.bdo'">
				</td>
			</tr>
		
		</table>
	</form>

</div>

</body>
</html>