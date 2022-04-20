<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYPAGE</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/css/main.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<%= request.getContextPath() %>/view/js/main.js"></script> 
<script src="<%= request.getContextPath() %>/view/js/mypage/mypage_index.js"></script> 
<!-- 로딩중 -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/css/fakeLoader.css">
<script src="<%= request.getContextPath() %>/view/js/fakeLoader.js"></script>

<body>
	<header id="header"><!-- 상단 헤더 불러오기 --></header>
	<div class="mypage_wrap_topHead">
		<div class="mypage_wrap_tBox">
			마이페이지 > 정보조회
		</div>
	</div>
	<div class="mypage_wrap">
		<div class="mypage__wrapSub">
			<div class="mypage__wrap_topBox">
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_index.jsp" style="background: #111; color:#fff;">고객정보</a></span>
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_like.jsp">좋아요</a></span>
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_trip.jsp">여행취향</a></span>
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_pay.jsp">결제내역확인</a></span>
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_review.jsp">작성리뷰조회</a></span>
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_qna.jsp">1:1문의</a></span>
			</div>
			<div class="mypage_boxContain">
				
			</div>
		</div>
	</div>
	<footer id="footer"><!-- 하단불러오기 --></footer>
	
		

<!-- 로딩 -->
 <div class="fakeLoader"></div>
 <script src="<%= request.getContextPath() %>/view/js/fakeLoader_speed.js"></script>
	
</body>
</html>