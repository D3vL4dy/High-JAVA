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
		마이페이지 > 결제내역확인
	</div>
</div>
<div class="mypage_wrap">
	<div class="mypage__wrapSub">
		<div class="mypage__wrap_topBox">
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_index.jsp">고객정보</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_like.jsp">좋아요</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_trip.jsp">여행취향</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_pay.jsp" style="background: #111; color:#fff;">결제내역확인</a></span>
			<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_review.jsp">작성리뷰조회</a></span>
				<span><a href="<%= request.getContextPath() %>/view/jsp/mypage/mypage_qna.jsp">1:1문의</a></span>
		</div>
		<div class="mypage_boxContain">
			<h3 class="mypage_boxPay_h3">결제 조회</h3>
			<ul class="mypage_boxPay">
				<li class="mypage_boxPay_li mypage_boxPay_li_t">
					<div class="m_Pay_no_t">주문번호</div>
					<div class="m_Pay_poto_t">상품제목</div>
					<div class="m_Pay_name_t">결제일</div>
					<div class="m_Pay_name_t">예약날짜</div>
					<div class="m_Pay_2_t">결제수단</div>
					<div class="m_Pay_2_t">결제상태</div>
					<div class="m_Pay_2_t">취소여부</div>
				</li>	
				<li class="mypage_boxPay_li">
					<div class="m_Pay_no">번호</div>
					<div class="m_Pay_poto">제주하루살기 패키지(디럭스룸)</div>
					<div class="m_Pay_name">2022/04/17</div>
					<div class="m_Pay_name">2022/05/17~2022/05/20</div>
					<div class="m_Pay_name">카드결제</div>
					<div class="m_Pay_name">결제완료</div>
					<div class="m_Pay_2">			
						<a href="#" class="mypage_PayBottom">결제취소</a>
					</div>
				</li>
				<li class="mypage_boxPay_li">
					<div class="m_Pay_no">번호</div>
					<div class="m_Pay_poto">신라호텔(이그제큐티브)</div>
					<div class="m_Pay_name">2022-04-17</div>
					<div class="m_Pay_name">2022/04/18~2022/04/19</div>
					<div class="m_Pay_name">카드결제</div>
					<div class="m_Pay_name">결제완료</div>
					<div class="m_Pay_2">			
						결제취소 불가
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>
<footer id="footer"><!-- 하단불러오기 --></footer>

<!-- 로딩 -->
 <div class="fakeLoader"></div>
 <script src="<%= request.getContextPath() %>/view/js/fakeLoader_speed.js"></script>
 
</body>
</html>