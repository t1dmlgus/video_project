<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- context 경로 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>





	<div class="header">
		<div class="nav">
			<a href="${path}">메인 |</a>
			<a href="${path}/member/view.do?userId=${sessionScope.userId}"> 마이페이지 |</a>
			
			<a href="${path}/cart/list.do"> 대여관리 </a>
		</div>

		<hr>	
	</div>
	<script>
	
	function back_click(){
		
		history.back();
	}
	</script>
	