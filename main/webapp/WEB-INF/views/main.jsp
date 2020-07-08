<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include/member_header.jsp" %>


<style>


.section1{display: flex;height: 90vh;justify-content: space-around;align-items: center;flex-wrap: wrap;}
.section1 .btn{height: 360px; flex-basis: 230px; border:none;transition: .02s; border-radius: 12px;}

.section1 > button i{font-size: 62px; transition: .3s;margin-bottom: 10px;}
.section1 > button:hover i{font-size: 82px;margin-bottom: 20px;}
.section1 > button span{display: block; font-size: 19px;margin-top: 20px; font-weight: bold; transition: .3s;}
.section1 > button:hover span{font-size: 22px;}
.section1 > button:hover{box-shadow: 7px 6px 8px rgb(146, 146, 146); transform:  scale(1.07);}
.section1 > button:nth-child(1):hover{ color: rgb(17, 181, 202);}
.section1 > button:nth-child(2):hover{ color: rgb(183, 13, 189);}
.section1 > button:nth-child(3):hover{ color: rgb(47, 103, 207);}
.section1 > button:nth-child(4):hover{ color: rgb(161, 159, 10);}
.btn{width: 230px;;height: 210px; border-radius: 8px;}


.search-box{
	padding: 10px; position: absolute; top:20%; left: 50%; transform: translate(-50%, -50%);
	height: 30px; border-radius: 30px; border: 1px solid #51e3d4; transition: .3s
}

.search-box:hover{

	box-shadow: 0 0 .5px 1px #51e3d4;
}

.search-txt{background-color:transparent;  
	padding: 0; width: 340px; border: none; outline: none; 
	font-size: 1rem; line-height: 30px; transition: .4s
}
.searchOption{background-color:transparent;
outline: none; border: 0; float: left; margin-top: 8px;}

.search-btn{
	background-color:transparent;  border:0px transparent solid;

	font-size: 22px;	
	width: 30px;
	height: 30px;
	border-radius: 30px;
	color: #51e3d4;
	margin-top: -3px;
}




</style>

</head>
<body>
	<c:choose>
				<c:when test="${sessionScope.userId == null}">
					
				</c:when>
				<c:when test="${sessionScope.verify == 7}">
					<%@ include file="include/member_menu.jsp" %>				
				</c:when>
				<c:otherwise>	
					<%@ include file="include/member_menu2.jsp" %>
				</c:otherwise>
		</c:choose>
			
	<form name="form1" method="post" action="${path}/movie/search.do" class="search-box"  display="none">
		  
		<input name="keyword" value="${map.keyword}" class="search-txt" placeholder="영화를 검색하세요">
		<!-- <input type="submit" value="검색"> -->
		<button type="submit" class="search-btn"><i class="fa fa-search" aria-hidden="true"></i></button>	
		
	
	</form>
	
	<div id="contents">
    <div class="section1" display="none">
          <button class="btnMember btn" onclick="location.href='${path}/member/manage.do'"><i class="fa fa-user" aria-hidden="true"></i><span>회원관리</span></button>  
          <button class="btnVideo btn" type="button"  onclick="location.href='${path}/movie/manage.do'"><i class="fa fa-film" aria-hidden="true"></i><span>비디오관리</span></button>
          <button class="btnRent btn" onclick="location.href='${path}/cart/list2.do'"><i class="fa fa-address-book-o" aria-hidden="true"></i><span>대여관리</span></button>
          <button class="btnSale btn" onclick="location.href='${path}/account/account_manage.do'"><i class="fa fa-usd" aria-hidden="true"></i><span>매출관리</span></button>  
    </div>

</div>
	
	
	
<script type="text/javascript">
	
	var aa = "${sessionScope.verify}"
	
	if(aa == 7){
		$(".section1").css("display","flex");
		$(".search-box").css("display","none");
		
	}else{
		$(".section1").css("display","none");
		$(".search-box").css("display","block");
		
	}
	
</script>
	
	
</body>
</html>