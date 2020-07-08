<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
<%@ include file="../include/member_header.jsp" %>
<link rel="stylesheet" href="${path}/resources/assets/css/style02.css">

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


	
<div id="contents">
    <div class="section1">
          <button class="btnMovie" onclick="location.href='${path}/account/account_day.do'"><i class="fa fa-search" aria-hidden="true"></i><span>일정산</span></button>  
          <button type="button" class="btnVideo" onclick="location.href='${path}/account/account_month.do'"><i class="fa fa-user" aria-hidden="true"></i></i><span>월정산</span></button>
          <button class="btnMovie" onclick="location.href='${path}/account/account_year.do'"><i class="fa fa-address-book-o" aria-hidden="true"></i><span>년정산</span></button>
            
    </div>

</div>




<script>
	
	function btnMovie_click() {
		//alert("movi누름");
		$(".search-box").css("display","block");
		$(".section1").css("display","none");
	}
	
</script>	
	
</body>
</html>