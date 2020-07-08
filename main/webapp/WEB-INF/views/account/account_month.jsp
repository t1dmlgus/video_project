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


	<div class="account_month">
	
	<h2>월 정산 목록</h2>
	<form class="fm1" name="form1" action="${path}/account/account_month2.do" method="post" >
		<tr>
			<td>
				<select class="monCont" name="month">
					<option value="2020-01-01">1월</option>
					<option value="2020-02-01">2월</option>
					<option value="2020-03-01" selected="selected">3월</option>
					<option value="2020-04-01">4월</option>
					<option value="2020-05-01">5월</option>
					<option value="2020-06-01">6월</option>
					<option value="2020-07-01">7월</option>
					<option value="2020-08-01">8월</option>
					<option value="2020-09-01">9월</option>
					<option value="2020-10-01">10월</option>
					<option value="2020-11-01">11월</option>
					<option value="2020-12-01">12월</option>
				</select>
			</td>
			<td>
				<input class="monBtn" type="submit" value="출력">
			</td>
		
		</tr>

				
	<div class="board">
	<table class="tb1">
		<tr>
			
			<th>대여일</th>
			<th>일 비디오 대여 수</th>
			
			<th>일 별 정산</th>
		</tr>
		<c:forEach var="row" items="${map.list}" varStatus="status">
		<tr>
			
			<td><fmt:formatDate value="${row.rentdate}" pattern="yyyy년  MM월  dd일"/> </td>
			<td>${row.state} 개</td>
			
			<td><fmt:formatNumber value="${row.sumprice}" pattern ="###,###,###"></fmt:formatNumber>원</td>
			
			
			
		</tr>
		
		</c:forEach>
		
		
		 
	</table>
	</div>
	<!--  
	<div>
		<c:forEach begin="1" end="${pageNum}" var="num">
			<span>
				<a href="${path}/account/account_month2.do?num=${num}">${num}</a>
			</span>
			
		</c:forEach>
	
	</div>
	-->
	
	</form>
	
		<c:choose>
			<c:when test="${cartVO.totalprice == 0}">
				해당 월 대여목록이 없습니다.
			</c:when>
			<c:otherwise>
			
			<div class="sumState">월 대여 개수
				<span>${cartVO.sumstate}</span>개
				
			</div>
			<div class="sumPric">월 총 금액
				<span><fmt:formatNumber value="${cartVO.totalprice}" pattern ="###,###,###"></fmt:formatNumber></span>
				원		
			</div>
			</c:otherwise>
		</c:choose>
	
	
	</div>
	<script>
		
			
	
			
		
	
	</script>
	
	
</body>
</html>