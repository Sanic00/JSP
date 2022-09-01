
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
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
<!-- action 바뀜 -->
<form action="member.mdo?cmd=zipCheck" name ="zipForm" method="post">
<!-- form넘어갈때 같이 넘어갈수 있도록 한다. -->
<input type = "hidden" name = "check" value = "n">
	<table>
		<tr>
			<td>
				동이름 입력 : <input type="text" name = "dong">
				<input type="button" value = "검색" onclick="dongCheck()">
			</td>
		</tr>
	</table>
</form> <!--form 닫는태그를 옮긴다. 동 검색까지만  -->


<table border="1">
<!-- <input type = "hidden" name = "check" value = "n">이게 넘어온다? -->
<c:if test="${check eq 'n'}">

		<c:if test="${zipcodeList.isEmpty() }">
			<tr><td align = "center"><br>검색된 결과가 없습니다.</td></tr>
		</c:if>
		
		<c:if test="${!zipcodeList.isEmpty() }">
			<tr><td align = "center"><br>
		※ 검색 후, 아래 우편번호를 클릭하여 자동으로 주소가 입력됩니다.</td></tr>
		</c:if>
		
		<c:forEach var="vo" items="${zipcodeList}">
	<tr><td >
     <a href ="javascript:sendAddress('${vo.getZipcode()}','${vo.getSido()}','${vo.getGugun()}','${vo.getDong()}','${vo.getRi()}','${vo.getBunji()}')">
     ${vo.getZipcode()}&nbsp;${vo.getSido()}&nbsp;${vo.getGugun()}&nbsp;${vo.getDong()}&nbsp;${vo.getRi()}&nbsp;${vo.getBunji()}
     </a>
     <br> </td></tr>
		</c:forEach>

</c:if>
	<tr>
	 	<td align="center">
	 	<a href="javascript.this.close()">닫기</a>
	 	</td>
	</tr> 	
</table>	 	
</div>


<script type="text/javascript" src = "script.js"></script>
</body>
</html>

</div>

<script type="text/javascript" src = "script.js"></script>
</body>
</html>