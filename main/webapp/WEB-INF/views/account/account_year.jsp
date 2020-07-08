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


	<div class="account_year">
	
	<h2>연 정산 목록</h2>
	<form class="fm1" name="form1" action="${path}/account/account_year.do" method="post" >
		<tr>
			<td>
				<select name="year" >
					<option value="2019-01-01">2019년</option>
					<option value="2020-01-01" selected="selected">2020년</option>
					<option value="2021-01-01">2021년</option>
				</select>
			</td>
			<td>
				<input type="submit" value="출력">
			</td>
		
		</tr>

	
	<div class="board">
	<table class="tb1">
		<tr>
			
			<th>대여월</th>
			<th>월 별 비디오 대여 수</th>
			
			<th>월 별 정산</th>
		</tr>
		<c:forEach var="row" items="${map.list}" varStatus="status">
		<tr>
			
			<td><fmt:formatDate value="${row.rentdate}" pattern="yyyy년 MM월"/> </td>
			<td>${row.state} 개</td>
			
			<td><fmt:formatNumber value="${row.sumprice}" pattern ="###,###,###"></fmt:formatNumber> 원</td>
			
			
			
		</tr>
		
		</c:forEach>
		
		
		 
	</table>
	</form>
	
	</div>
	
		<c:choose>
			<c:when test="${cartVO.totalprice == 0}">
				해당 월 대여목록이 없습니다.
			</c:when>
			<c:otherwise>
			
			<div class="sumState"><fmt:formatDate value="${cartVO.rentdate}" pattern="yyyy년 "/><br/>대여 개수
			<span>${cartVO.sumstate}</span> 개
				
			</div>
			<div class="sumPric"><fmt:formatDate value="${cartVO.rentdate}" pattern="yyyy년 "/><br/> 총 금액
				<span><fmt:formatNumber value="${cartVO.totalprice}" pattern ="###,###,###"></fmt:formatNumber></span> 원
					
			</div>
			</c:otherwise>
		</c:choose>
	
	</div>
	<script>
	
	  

	  
	
	
	
	
	</script>
	
	
</body>
</html>