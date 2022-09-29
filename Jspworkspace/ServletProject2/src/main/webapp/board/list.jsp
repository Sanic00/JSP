<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!--날짜--> 
    <%@ include file = "view/color.jsp" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
function check() {
	if(document.find_frm.findbox.value==""){
	 	alert("검색어를 입력해주세요");
		return false;
	}
}
function frm_sub (i) {
	i_frm.action="/ServletProject2/board/list.bdo?pageNum="+i;
	i_frm.submit();
}


</script>
</head>
<body bgcolor = "${bodyback_c}">

<div align ="center"><b>글 목록(전체 글 :${count})</b>
	
<table width ="700">
	<tr>
		<td align ="right" bgcolor = "${value_c}">
			<a href ="/ServletProject2/board/list.bdo">전체목록</a>
		</td>
		<td align ="right" bgcolor = "${value_c}">
			<a href ="/ServletProject2/board/writeForm.bdo">글쓰기</a>
		</td>
	</tr>
</table>	

<c:if test="${count ==0 }">
	
<table width ="700" border = "1" cellpadding ="0" cellspacing = "0"> 
	<tr>
		<td align ="center">
			게시판에 저장된 글이 없습니다.
		</td>
	</tr>
</table>
	</c:if>

<c:if test="${count > 0 }">
<table width ="700" border = "1" cellpadding ="0" cellspacing = "0" align = "center">
		<tr height = "30" bgcolor ="${value_c}">
			<td align ="center" witdh="50">번호</td>
			<td align ="center" witdh="250">제목</td>
			<td align ="center" witdh="100">작성자</td>
			<td align ="center" witdh="150">작성일</td>
			<td align ="center" witdh="50">조회수</td>
			<td align ="center" witdh="100">IP</td>
	</tr>
	
	<c:forEach var="article" items="${articleList}" >
	
	<tr height = "30">	<!--내림차순으로 출력하기 위해 -- 연산자  -->
	<td align = "center" width ="50">
	<c:out value="${number}"/>
	<c:set var="number" value="${number-1}"/>
	</td>
	<!-- 제목을 눌렀을때 글의 내용이 보이도록 연결 시켜줘아댜된다 -->
	<td width ="250">
	
		<c:if test="${article.depth > 0 }">
			<img alt="#" src="img/level.gif" width= "${5* article.depth }" height = "16">
			<img src= "img/re.gif">
		</c:if>
	
		<c:if test="${article.depth == 0 }">
			<img alt="" src="img/level.gif" width= "${5* article.depth }" height = "16">
		</c:if>
	
	
	
	<a href = "/ServletProject2/board/content.bdo?num=${article.num }&pageNum=${currentPage}">
	${article.subject }
	</a>
	<c:if test="${article.readcount >= 20 }">
	<img src="img/hot.gif" border = "0" height = "16">
	</c:if>
	</td>
	
	<td align = "center" width ="100">
	<a href = "mailto: ${article.email }">
	${article.writer }</a>
	</td>
	
	<td align ="center" witdh="150">
	${article.regdate }
	</td>
	
	<td align ="center" witdh="50">${article.readcount }</td>
	
	<td align ="center" witdh="100">${article.ip}</td>
	</tr>
	
	</c:forEach> 
</table> 
</c:if>


<!-- 여기다가 페이지 블록  -->
<c:if test="${count >0 }">

	<c:set var="pageBlock" value="${5 }"/>

	<c:set var="imsi" value="${count % pageSize == 0? 0:1 }"/>
	
 	<c:set var="pageCount" value ="${count/pageSize + imsi }"/>
 
 	<fmt:parseNumber var="result" value="${(currentPage-1)/pageBlock }" integerOnly="true"></fmt:parseNumber>
 	
 	<c:set var="startPage" value="${result*pageBlock+1 }"/>
 
 
  	<c:set var="endPage" value="${startPage + pageBlock -1 }"/>

		<c:if test="${endPage > pageCount }">
			<c:set var="endPage" value="${pageCount}"/>
		</c:if>	
		
		<c:if test="${startPage > pageBlock }">	
	 		<%-- <a href="/ServletProject2/board/list.bdo?pageNum=${startPage-pageBlock }">[이전]</a> --%>
	 		<a href="#" onclick="frm_sub(${startPage-pageBlock})">[이전]</a>
		</c:if>	
		
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<%-- <a href="/ServletProject2/board/list.bdo?pageNum=${i }">[${i }]</a> --%>
			<a href="#" onclick="frm_sub(${i}")>[${i}]</a>
		</c:forEach>

 		<c:if test="${endPage < pageCount }">
 			<%-- <a href="/ServletProject2/board/list.bdo?pageNum=${startPagepageBlock }">[다음]</a> --%>
 			<a href="#" onclick="frm_sub(${startPagepageBlock })">[다음]</a>
		</c:if>
</c:if>

<form action="" method="post" name="i_frm">
	<input type="hidden" name="find_box" value="${find_box}">
	<input type="hidden" name="find" value="${find}">
	
</form>





<!-- 검색 창 -->
	<form action="/ServletProject2/board/list.bdo" method="post" name="find_frm" 
	onsubmit="return check()">
		<select name = "find" >
			<option value ="">작성자</option>
			<option value ="subject">제목</option>
			<option value ="content">내용</option>
		</select>
		<input type="text" name ="find_box">
		<input type="submit" name ="검색">
	</form>
</div>



</body>
</html>