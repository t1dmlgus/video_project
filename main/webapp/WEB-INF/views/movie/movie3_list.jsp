
<%@page import="com.example.spring01.domain.MovieVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원등록 페이지</title>
<%@ include file="../include/member_header.jsp" %>



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
	
	
	
	<form name="form3" method="post" action="${path}/movie/search2.do">
		<select name="searchOption">
			
			<!-- 검색조건을 검색처리 후 결과 화면에 보여주기 위해 c:out 출력태그 사용, 삼항 연산자 -->
			<option value="movie"  <c:out value="${map.searchOption == 'movie'?'selected':''}"/>>영화제목</option>
			<option value="genre"  <c:out value="${map.searchOption == 'genre'?'selected':''}"/>>장르</option>
			<option value="grade"  <c:out value="${map.searchOption == 'grade'?'selected':''}"/>>등급</option>
			<option value="nation"  <c:out value="${map.searchOption == 'nation'?'selected':''}"/>>국가</option>
			<option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/>>all</option>
			
			
		</select>
		<input name="keyword" value="${map.keyword}">
		<input type="submit" value="검색">
		
		
		
	
	</form>
	
		<div class="board">
	<h2>회원 목록</h2>
		<table class="tb1">
	<c:forEach var="row" items="${map.list}">
	<div>
		<li>
		 M${row.mno}
		<a href="${path}/movie/movie2_view.do?mno=${row.mno}">${row.movie}</a>
			
			${row.runningtime}분
			${row.releaseday}
			${row.nation}
			${row.grade}
			
			
			<c:if test="${sessionScope.verify==7}">
				<input type="button" class="registerVideo" onclick="location.href='${path}/movie/video_insert.do?mno=${row.mno}'" value="비디오 등록하기">
			</c:if>
		</li>
			
		
			
	<div>
	</c:forEach>
	</table>
	</div>
<script>


$(document).ready(function(){
    // test라는 클래스를가진 div를 클릭할 경우 "테스트입니다요."라는 alert가 뜬다.
    $(".registerVideo").on("click", function(){  
        alert("비디오 등록됬습니다.");
    });    
});



	
</script>


	
	
</body>
</html>