<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
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
	<h2>비디오 목록</h2>
	
	
	
	<form name="form2" method="post" action="${path}/movie/list.do">
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
			<th>비디오</th>
			<th>영화</th>
			<th>러닝타임</th>
			
			<th>등급</th>
			<th>개봉일</th>
			<th>국가</th>
			<th>상태</th>
			<th>가격</th>
			
		</tr>
		<c:forEach var="row" items="${map.list}">
		<tr>
			<td><a href="#" onclick="btn_a(+${row.movie})">V${row.vno}</a></td>
			<td><a href="${path}/movie/movie_view.do?vno=${row.vno}" class="btn_b" onclick="btn_b();">${row.movie}</a></td>
			<td>${row.runningtime}분</td>
			
			<td>${row.grade}</td>		
			<td>${row.releaseday}</td>	<!-- MemberVO => sql.date -->	
			<td>${row.nation}</td> 
			<td>
			
			<c:if test="${row.state == 1}">
			<span style="color: green">대여가능</span>
			</c:if>
			<c:if test="${row.state == 0}">
			<span style="color: red">대여불가</span>
			
			</c:if>
			
			</td>
			<td>${row.video_price}</td>		
		</tr>
		</c:forEach>
	</table>
	
	
	</div>
	<script>
		
		
		
	
	</script>

	
	
</body>
</html>