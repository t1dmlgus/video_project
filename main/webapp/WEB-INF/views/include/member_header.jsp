<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jstl 시간 출력 태그 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- context 경로 -->



<c:set var="path" value="${pageContext.request.contextPath}"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <!-- css -->
    <link rel="stylesheet" href="${path}/resources/assets/css/reset01.css">
    <link rel="stylesheet" href="${path}/resources/assets/css/swiper.css">
    <link rel="stylesheet" href="${path}/resources/assets/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/resources/assets/css/style06.css">
    
    <!-- 웹 폰트 -->
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&amp;subset=korean" rel="stylesheet">
    

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<div class="header">
		<c:choose>
			<c:when test="${sessionScope.userId == null}">
				<a class="lg1" href="${path}/member/login.do">로그인</a>
			</c:when>
			<c:otherwise>
				<div class="logout1"><a href="${path}/member/logout.do">로그아웃</a></div>
				<div class="login1"><span>${sessionScope.userName} </span>님이 로그인 중입니다.</div>
			</c:otherwise>
		</c:choose>
	</div>