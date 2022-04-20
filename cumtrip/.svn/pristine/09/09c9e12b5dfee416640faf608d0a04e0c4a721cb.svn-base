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
<script src="<%= request.getContextPath() %>/view/js/findIDpass.js"></script> 

<!-- 로딩중 -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/css/fakeLoader.css">
<script src="<%= request.getContextPath() %>/view/js/fakeLoader.js"></script>
</head>
<body>

<header id="header"><!-- 상단 헤더 불러오기 --></header>
<div class="mypage_wrap_topHead">
	<div class="mypage_wrap_tBox">
		마이페이지 > 1:1문의
	</div>
</div>
<div class="mypage_wrap">
	<div class="mypage__wrapSub">
		<div class="mypage__wrap_topBox">
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_index.jsp">고객정보</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_like.jsp">좋아요</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_trip.jsp">여행취향</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_pay.jsp">결제내역확인</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_review.jsp">작성리뷰조회</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_qna.jsp" style="background: #111; color:#fff;">1:1문의</a></span>
		</div>
		<div class="mypage_boxContain">
			 <h3 class="mypage_Trip_h3">여행취향 정보</h3>
			 <ul class="mypage_boxTrip">
				<li class="mypage_boxTrip_li mypage_boxTrip_li_t">
					<div class="m_Trip_no_t">취향분류 코드</div>
					<div class="m_Trip_poto_t">취향</div>
					<div class="m_Trip_name_t">관련 추천장소</div>
					<div class="m_Trip_2_t">선호도</div>
				</li>	
				<li class="mypage_boxTrip_li">
					<div class="m_Trip_no">T0223</div>
					<div class="m_Trip_poto">힐링</div>
					<div class="m_Trip_name">제주 레일 바이크</div>
					<div class="m_Trip_2">50%</div>
				</li>
			</ul>
			<div class="mypage_boxTrip_bBoX">
				<a href="#" class="mypage_TripBottom">여행취향 작성</a>
				<a href="#" class="mypage_TripBottom">여행취향 수정</a>
				<a href="#" class="mypage_TripBottom">여행취향 삭제</a>
			</div>
		</div>
	</div>
</div>
<footer id="footer"><!-- 하단불러오기 --></footer>

<!-- 로딩 -->
 <div class="fakeLoader"></div>
 <script src="<%= request.getContextPath() %>/view/js/fakeLoader_speed.js"></script>
 
</body>
</html>