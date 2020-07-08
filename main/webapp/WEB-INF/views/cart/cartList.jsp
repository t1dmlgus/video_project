<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>대여목록</title>
<%@ include file="../include/member_header.jsp" %>

	<style type="text/css">
	 .btnReturn{
	 	 background-color:transparent;
		  color:#fff  
	 } 
	 .td8{background-color: #003973;}
	</style>

</head>
<body>
<%@ include file="../include/member_menu2.jsp" %>
<h2>대여 확인</h2>
<c:choose>
	<c:when test="${map.count == 0 }">
		대여목록이 없습니다
	</c:when>
	<c:otherwise>
	
	
	<form name="form1" id ="form1" method="post">
		<table border="1" width="800px" style="text-align: center">
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

			
			
			<c:forEach var="row" items="${map.list}" varStatus="status">
				<tr>
					
					<td>${status.count}</td>
					<td>${row.vno}</td>
					<td>${row.movie}</td>
					<td>${row.userId}</td>
					<td><fmt:formatDate value="${row.rentdate}" pattern="yyyy년 MM월 dd일   HH시 mm분"/></td>
					<td><fmt:formatDate value="${row.returndate}" pattern="yyyy년 MM월 dd일   HH시 mm분"/></td>
					<td>
						<c:if test="${row.state == 0}">
							대여중
						</c:if>
					</td>
					<td>${row.price}</td>
					<td class="td8">
						<Button type="button" class="btnReturn" onclick="location.href='${path}/cart/return.do?vno=${row.vno}'">반납하기</Button>
					</td>
				</tr>
			</c:forEach>
			
		</table>	
	</form>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	
	//var a = ${row.movie};

	$(".btnReturn").click(function(){
		alert("반납되었습니다.");
	});
	

</script>



</body>
</html>