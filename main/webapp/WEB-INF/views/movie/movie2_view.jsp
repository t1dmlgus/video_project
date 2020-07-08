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
	<form action="${path}/member/login.do" method="post"  >
	
		<div>
			영화: ${dto.get(0).movie}
																			<!-- ${sessionScope.userName} 됨 -->
		</div>
		<div>
			상영시간: ${dto.get(0).runningtime}분
																			<!-- ${sessionScope.userName} 됨 -->
		</div>
		<div>
			개봉일: ${dto.get(0).releaseday}
																			<!-- ${sessionScope.userName} 됨 -->
		</div>
		<div>
			등급: ${dto.get(0).grade}
																			<!-- ${sessionScope.userName} 됨 -->
		</div>
		<div>
			영화: ${dto.get(0).nation}
																			<!-- ${sessionScope.userName} 됨 -->
		</div>
		<div>
			영화: ${dto.get(0).grade}
																			<!-- ${sessionScope.userName} 됨 -->
		</div>
		
		</form>
		
		<form name="form2" method="post">
			
				<c:forEach var="item" items="${dto}" varStatus="status">
					<c:choose>
						<c:when test="${dto[status.index].state ==1 }">
							<c:out value="${dto[status.index].vno}"/>
							
							<!-- <input type="hidden" id="vn" value="${dto[status.index].vno}"/> -->
							
							<input type="submit" id="vv" onclick="btn1(${dto[status.index].vno})" value="대여하기"/>
						</c:when>		
						<c:otherwise>
							<c:out value="${dto[status.index].vno}"/>
							<input type="submit" onclick="btn2()" value="대여불가">
						</c:otherwise>
					</c:choose>
				</c:forEach>
			
			
		</form>
		
		
	</form>
	
	
	</div>
	<script>
		
		var a = "${sessionScope.userId}"
		var b = "${dto.get(0).movie}"
		
		function btn1(event){
			var ete = event;
			
			if(${sessionScope.userId==null}){
				alert("로그인후 이용가능합다.");
				document.form2.action = "${path}/member/login.do";
			}else{
				alert(ete+"대여하겠습니다.");
				document.form2.action = "${path}/cart/insert.do?vno="+ete;
				
			}
		};
		
		
		function btn2(){
			alert("이미 대여중입니다.");
		}
		
		$(document).ready(function(){
			$("#btnUpdate").click(function(){
				// 확인 대화상자	
				if(confirm("수정하시겠습니까?")){
					document.form1.action = "${path}/member/update.do";
					document.form1.submit();
				}
			});
		});
		$(document).ready(function(){
			$("#btnDelete").click(function(){
				// 확인 대화상자 
				if(confirm("삭제하시겠습니까?")){
					document.form1.action = "${path}/movie/delete.do";
					document.form1.submit();
				}
			});
		});
	
	
	
	</script>
	
	
	
</body>
</html>