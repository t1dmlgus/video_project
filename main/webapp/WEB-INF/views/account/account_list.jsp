<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>회원 목록</title>
<%@ include file="../include/member_header.jsp" %>

	<style>
	.tb1{margin: 0 auto;text-align: center; position: relative;
		 }
	.sumPrice{display: inline-block; color: #ff0000; font-size: 30px; font-weight: 	bold;
				margin-top: 50px; margin-left: 	70%;}
    .sumPrice > span{color:#ccc; font-size: 16px; font-weight: none;}				
</style>




</head>
<body>

<%@ include file="../include/member_menu.jsp" %>




	<div class="account_day">
	<h1>일 정산 목록</h2>
	
	
	<c:choose>
			<c:when test="${cartVO.sumprice == 0}">
				<h2 class="date2">해당 일 대여목록이 없습니다.</h2>
			</c:when>
			<c:otherwise>
	
	<h2 class="date2"><fmt:formatDate value="${cartVO.rentdate}" pattern="YYYY년 MM월 dd일"/></h2> 
	
	<div class="board">
	<table class="tb1">
		<tr>
			<th>번호</th>
			<th>비디오번호</th>
			<th>영화</th>
			<th>아이디</th>
			<th>상태</th>
			<th>가격</th>
		</tr>
		<c:forEach var="row" items="${map.list}"  varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>v${row.vno}</td>
			<td>${row.movie}</td>
			<td>${row.userId}</td>
			<td>
				<c:if test="${row.state == 0}">
					<span class="co1">대여중</span>
				</c:if>
				<c:if test="${row.state == 1}">
							<span class="co2">대여완료</span>
				</c:if>
			</td>
			<td>${row.price}</td>
			
			
		</tr>
		
		</c:forEach>
		
	</table>
	</div>
	
	<div class="totalCount">일 대여 개수
		<span>${cartVO.sumstate}</span>개
	</div>
	
	<div class="sumPric">금액
			<span><fmt:formatNumber value="${cartVO.sumprice}" pattern ="$###,###,###"></fmt:formatNumber></span>
				원
			</div>
	
			</c:otherwise>
		</c:choose>
	
	</div>
</body>
</html>