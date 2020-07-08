<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>회원 목록</title>
<%@ include file="../include/member_header.jsp" %>
</head>
<body>

<%@ include file="../include/member_menu.jsp" %>


<form name="form2" method="post" action="${path}/member/list.do">
		<select name="searchOption">
			
			<!-- 검색조건을 검색처리 후 결과 화면에 보여주기 위해 c:out 출력태그 사용, 삼항 연산자 -->
			<option value="userId"  <c:out value="${map.searchOption == 'userId'?'selected':''}"/> >회원 아이디</option>
			<option value=userName  <c:out value="${map.searchOption == 'userName'?'selected':''}"/> >회원 이름</option>
			<option value="mail"  <c:out value="${map.searchOption == 'mail'?'selected':''}"/> >메일</option>
			<option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/> >all</option>
			
			
		</select>
		<input name="keyword" value="${map.keyword}">
		<input type="submit" value="검색">
		
		
		
	
	</form>





	
	
	
	<div class="board">
	<h2>회원 목록</h2>
		<table class="tb1">

		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>회원가입일자</th>
		</tr>
		<c:forEach var="row" items="${map.list}">
		<tr>
			<td><a href="${path}/member/view.do?userId=${row.userId}">${row.userId}</td>
			<td>${row.userName}</td>
			<td>${row.mail}</td>
			<td>${row.regDate}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>