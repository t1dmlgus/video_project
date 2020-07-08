
<%@page import="com.example.spring01.domain.MovieVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원등록 페이지</title>
<%@ include file="../include/member_header.jsp" %>


<style type="text/css">

.tb1{text-align:center}
</style>


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
	
	
	
	<form name="form3" method="post" action="${path}/movie/search.do">
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
	
		<table class="tb1">
	
	<tr>
		<th>영화번호</th>
		<th>영화</th>
		<th>상영시간</th>
		<th>개봉일</th>
		<th>국가</th>
		<th>등급</th>
	</tr>
	
	
	
	
	<c:forEach var="row" items="${map.list}">
	
	
	
	
	<div>
	
			<tr>
				<td> M${row.mno}</td>
				<td><a href="${path}/movie/movie2_view.do?mno=${row.mno}">${row.movie}</a></td>
				<td>${row.runningtime}분</td>
				<td>${row.releaseday}</td>
				<td>${row.nation}</td>
				<td>${row.grade}</td>	
			
			
			
	
				<c:if test="${sessionScope.verify==7}">
					<td>
						
						<input type="button" onclick="location.href='${path}/movie/movie2_select.do?mno=${row.mno}'" value="수정하기">
						
					</td>
				</c:if>
			</tr>
		
			
	<div>
	</c:forEach>

	</table>
	
	</div>
<script>
	
	
	
</script>


	
	
</body>
</html>