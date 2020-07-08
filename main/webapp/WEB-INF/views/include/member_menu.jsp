<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- context 경로 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
	
	
	
	
	<div class="header">
		<button class="btnBack" onclick="back_click();">뒤로</button>
		<div class="nav">
			<a href="${path}/member/manage.do">회원관리</a>
			<a href="${path}/movie/manage.do">비디오관리</a>
			<a href="${path}/cart/list21.do?num=1">대여관리</a>
			<a href="${path}/account/account_manage.do">정산관리</a>
		</div>
	
		
		<hr>
	</div>
	<script>
	
	function back_click(){
		
		history.back();
	}
	</script>
	