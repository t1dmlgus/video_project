<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
<%@ include file="../include/member_header.jsp" %>

<link rel="stylesheet" href="${path}/resources/assets/css/style02.5.css">
</head>
<body>
<%@ include file="../include/member_menu.jsp" %>

<div>
<li>
	<form class="search-box" name="form2" method="post" style="display:none" action="${path}/movie/list.do">
		<select name="searchOption" class="searchOption">
			
			<!-- 검색조건을 검색처리 후 결과 화면에 보여주기 위해 c:out 출력태그 사용, 삼항 연산자 -->
			<option value="movie"  <c:out value="${map.searchOption == 'movie'?'selected':''}"/>>영화제목</option>
			<option value="genre"  <c:out value="${map.searchOption == 'genre'?'selected':''}"/>>장르</option>
			<option value="grade"  <c:out value="${map.searchOption == 'grade'?'selected':''}"/>>등급</option>
			<option value="nation"  <c:out value="${map.searchOption == 'nation'?'selected':''}"/>>국가</option>
			<option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/>>all</option>
			
			
		</select>
		<input name="keyword" value="${map.keyword}"  class="search-txt">
		<!-- <input type="submit" value="검색" class="search-btn"> -->
		<button type="submit" class="search-btn"><i class="fa fa-search" aria-hidden="true"></i></button>	
		
		
	
	</form>
	</li>
	
</div>
	
<div id="contents">
    <div class="section1">
        <button class="btnSearch" onclick="btnMovie_click();"><i class="fa fa-search" aria-hidden="true"></i><span>영화검색</span></button>
          <button class="btnSearch"  onclick="location.href='${path}/movie/write.do'"><i class="fa fa-film" aria-hidden="true"></i></i><span>영화등록</span></button>  
          <button class="btnMovie" type="button"  onclick="btnMovie_click();"><i class="fa fa-minus-square" aria-hidden="true"></i><span>영화수정</span></button>  

          <button type="button" class="btnVideo" onclick="btnMovie_click();"><i class="fa fa-trash-o" aria-hidden="true"></i><span>영화삭제</span></button>  
    </div>
    <div class="section2">
        <button class="btnSearch" onclick="btnVideo_click();"><i class="fa fa-search" aria-hidden="true"></i><span>비디오검색</span></button>
        <button class="btnSearch" onclick="location.href='${path}/movie/video_write.do'"><i class="fa fa-arrow-circle-down" aria-hidden="true"></i><span>비디오등록</span></button>  
        
        <button type="button" class="btnVideo" onclick="location.href='${path}/movie/video_write'"><i class="fa fa-trash-o" aria-hidden="true"></i><span>비디오삭제</span></button>  
  </div>

</div>
	
	
	
<script>
	
	function btnMovie_click() {
		//alert("movi누름");
		
		var t1 = $(".search-btn"); 
		var t2 = $(".search-box"); 
		
		$(".search-box").css("display","block");
		$(".section1").css("display","none");
		$(".section2").css("display","none");
		
		
		
 		t1.on("click", function(){
			
			$(".search-box").attr("action", "${path}/movie/search.do")	
		});
		
		
	}
	
	
	
	
	
	
	function btnVideo_click(){
		$(".search-box").css("display","block");
		$(".section1").css("display","none");
		$(".section2").css("display","none");
		
		$("search-box").attr("action","${path}/movie/list.do")
	}
	
	
		
		
	
	
</script>
	

</body>
</html>