<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원등록 페이지</title>
<%@ include file="../include/member_header.jsp" %>
</head>
<body>
<%@ include file="../include/member_menu.jsp" %>
	<h2>영화등록</h2>
	<h3> 등록할 영화를 입력하세요</h3>
	
	
	<div class="login">
	<form name="form1" method="post" action="${path}/movie/insert.do">
		<table border="1" width="400px">
			<tr>
				<td>영화명</td>
				<td><input name="movie"></td>
			</tr>
			<tr>
				<td>상영시간</td>
				<td><input type="text" name="runningtime"></td>
			</tr>
			<tr>
				<td>개봉일</td>
				<td><input name="releaseday" placeholder="yyyy-mm-dd"></td>
			</tr>
			<tr>
				<td>국가</td>
				<td><input name="nation"></td>
			</tr>
			<tr>
				<td>등급</td>
				<select name="grade" >
					<option value="1">전체이용가</option>
					<option value="2">12세 관람가</option>
					<option value="3">15세 관람가</option>
					<option value="4">청소년 관람불가</option>
				</select>	
			</tr>
			
			
			
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="확인">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>