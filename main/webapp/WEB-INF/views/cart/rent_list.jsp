<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>대여 목록</title>
<%@ include file="../include/member_header.jsp" %>
</head>
<body>
<%@ include file="../include/member_menu.jsp" %>
	<h2>대여목록</h2>
	
	
	<div class="board">
	<table class="tb1">
		<thead>
			<tr>
				<th>대여번호</th>
				<th>비디오번호</th>
				<th>영화</th>
				<th>아이디</th>
				<th>대여일</th>
				<th>반납일</th>
				<th>상태</th>
				<th>가격</th>	
			</tr>
		</thead>
		<tbody>
		<c:forEach var="row" items="${list}" varStatus="status" >
		<tr>
			<td>${status.count}</td>
			<td>V${row.vno}</td>
			<td>${row.movie}</td>
			<td>${row.userId} </td>
			<td><fmt:formatDate value="${row.rentdate}" pattern="yyyy년 MM월 dd일   HH시 mm분"/></td>
			<td><fmt:formatDate value="${row.returndate}" pattern="yyyy년 MM월 dd일   HH시 mm분"/> </td>
			<td>
			
				<c:choose>
				
				<c:when test="${row.state == 0}">
					<span style=" color:green" font-weight="bold">대여중</span>				
				</c:when>
				<c:otherwise>	
					반납완료
				</c:otherwise>
			</c:choose>
				
				
			</td>
			
			<td>${row.price}</td>
		
		</tr>
		</c:forEach>
		
		</thead>
	</table>
	
		<div class="page">
			 <c:if test="${prev}">
			 <span>[ <a href="/cart/rent_list?num=${startPageNum - 1}">이전</a> ]</span>
			</c:if>
			
			<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
			  <span>
			   <a href="${path}/cart/list21.do?num=${num}">${num}</a> 
			 </span>
			</c:forEach>
			
			<c:if test="${next}">
			 <span>[ <a href="/cart/rent_list?num=${endPageNum + 1}">다음</a> ]</span>
			</c:if>
		</div>
	
	</div>
</body>
</html>