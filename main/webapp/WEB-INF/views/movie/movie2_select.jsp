<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 상세 페이지</title>
<%@ include file="../include/member_header.jsp" %>
<%@page session="true"%>
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

<div class="login">
	<h2>영화 상세정보</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>영화번호</td>
				 						<!-- id는 수정이 불가능하도록 readonly속성 추가 -->
				 								
				<td><input name="mno" value="${dto.mno}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>영화</td>
				<td><input name="movie" value="${dto.movie}"></td>
			</tr>
			<tr>
				<td>러닝타임</td>
				<td><input name="runningtime" value="${dto.runningtime}"></td>
			</tr>
			<!-- 누락된 부분 -->
			<tr>
				<td>등급</td>
				<td><input name="grade" value="${dto.grade}"></td>
			</tr>
			<!-- 누락된 부분 -->
			
			<tr>
				<td>개봉일</td>
				<td><input name="releaseday" value="${dto.releaseday}"></td>
			</tr>
			<tr>
				<td>나라</td>
				<td><input name="nation" value="${dto.nation}"></td>
			</tr>
	
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" id="btnUpdate">
					<input type="button" value="삭제" id="btnDelete">
					
				</td>
			</tr>
		</table>
	</form>
	</div>
	<script>
	$(document).ready(function(){
		$("#btnUpdate").click(function(){
			// 확인 대화상자	
			if(confirm("수정하시겠습니까?")){
				document.form1.action = "${path}/movie/movie2_update.do";
				document.form1.submit();
				
			}
			alert("수정 되었습니다.");
		});
	});
	$(document).ready(function(){
		$("#btnDelete").click(function(){
			// 확인 대화상자 
			if(confirm("삭제하시겠습니까?")){
				document.form1.action = "${path}/movie/movie2_delete.do";
				document.form1.submit();
			}
			alert("삭제 되었습니다.");
		});
	});
	
	
	</script>
	
	
	
</body>
</html>