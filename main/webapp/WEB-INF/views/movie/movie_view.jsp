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
	<form action="form1" method="post"  >
		<div>
			영화: ${dto.movie}
																			<!-- ${sessionScope.userName} 됨 -->
		</div>
		<div>
			상영시간: ${dto.runningtime}
				
		</div>
		<div>
			등급: ${dto.grade}
			
		</div>
		<div>
			개봉일: ${dto.releaseday}
			
		</div>
		<div>
			국가: ${dto.nation}
			
		</div>
		
	</form>
	

	
	
			<!-- 게시물번호를 hidden으로 처리 -->
			
			
		<!-- 본인이 쓴 게시물만 수정, 삭제 가능하도록 처리 
			<button type="button" id="btnUpdate">대여
				<input type="hidden" name="bno" value="${dto.vno}">
			</button>
			
			
			<button type="button" id="btnDelete">삭제?</button>
		
	-->
		<form name="form2" method="post" >
			<input type="hidden" name="vno" value="${dto.vno}">
			<c:choose>
				<c:when test="${dto.state == 1}">
					<input type="submit" onclick="btn2()" value="대여가능">
				</c:when>
				<c:otherwise>	
					<input type="submit" onclick="btn1()" value="대여불가">
				</c:otherwise>
				
				
				
				
			</c:choose>
			
			
			
	
	
		
	</div>	
	 
	 </div>
<script>
	
	// java 변수 -> script
	
	//var a ="${map.list.get(b).movie}"
	var a= ${dto.vno};
	var b =<%=(String)session.getAttribute("userId")%> 

	
	function btn1(){
		alert("로그인 후 대여 가능합니다.");
		document.form2.action = "${path}/member/login.do";
	}
	function btn2(){
		alert(a+"대여하겠습니다.");
		document.form2.action = "${path}/cart/insert.do";
		
	}
	
	
<!-- 
	$(document).ready(function(){
		
		
		
		$("#btnRent").click(function(){
			if(b==null){
				alert("로그인ㄷ하세요");
			}else{
				alert(a+"대여ㅑ")
				document.form2.action = "${path}/cart/insert.do";	
				alert("대여되었습ㄴ디ㅏ.")
			}
					
			});
		});
		
		
	-->
	
</script>
	 
</body>
</html>