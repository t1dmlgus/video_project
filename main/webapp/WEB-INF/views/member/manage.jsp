<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
<%@ include file="../include/member_header.jsp" %>
<link rel="stylesheet" href="${path}/resources/assets/css/style02.css">

</head>
<body>
			<c:choose>
				<c:when test="${sessionScope.userId == null}">
					
				</c:when>
				<c:when test="${sessionScope.verify == 7}">
					<%@ include file="../include/member_menu.jsp" %>				
				</c:when>
				<c:otherwise>	
					<%@ include file="../include/member_menu2.jsp" %>
				</c:otherwise>
			</c:choose>



<div>
	<form class="search-box" name="form2" method="post" action="${path}/member/list.do" style="display:none">
		<select class="searchOption" name="searchOption" >
			
			<!-- 검색조건을 검색처리 후 결과 화면에 보여주기 위해 c:out 출력태그 사용, 삼항 연산자 -->
			<option value="userId"  <c:out value="${map.searchOption == 'userId'?'selected':''}"/> >회원 아이디</option>
			<option value=userName  <c:out value="${map.searchOption == 'userName'?'selected':''}"/> >회원 이름</option>
			<option value="mail"  <c:out value="${map.searchOption == 'mail'?'selected':''}"/> >메일</option>
			<option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/> >all</option>
			
			
		</select>
		<input class="search-txt" name="keyword" value="${map.keyword}" placeholder="  회원을 입력하세요" color="#red">
		<!-- <input type="submit" value="검색"> -->
		<button class="search-btn" type="submit" ><i class="fa fa-search" aria-hidden="true"></i></button>	
		
	
		
		
		
	</form>
	
</div>
	
<div id="contents">
    <div class="section1">
          <button class="btnMovie" onclick="btnMovie_click();"><i class="fa fa-search" aria-hidden="true"></i><span>회원검색</span></button>  
          <button type="button" class="btnVideo" onclick="location.href='${path}/member/write.do'"><i class="fa fa-user" aria-hidden="true"></i></i><span>회원등록</span></button>
          <button class="btnMovie" onclick="btnMovie_click();"><i class="fa fa-address-book-o" aria-hidden="true"></i><span>회원수정</span></button>
          <button class="btnMovie" onclick="btnMovie_click();"><i class="fa fa-trash-o" aria-hidden="true"></i><span>회원삭제</span></button>  
    </div>

</div>




<script>
	
	function btnMovie_click() {
		//alert("movi누름");
		$(".search-box").css("display","block");
		$(".section1").css("display","none");
	}
	
</script>	
	
</body>
</html>