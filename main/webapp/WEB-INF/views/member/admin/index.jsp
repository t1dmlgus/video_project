<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../../include/member_header.jsp" %>
</head>
<body>
<%@ include file="../../include/member_menu.jsp" %>

		<h2>${sessionScope.userName}(${sessionScope.userId})님 환영합니다.</h2>
		<h3>관리자 페이지</h3>	
	
</body>
</html>