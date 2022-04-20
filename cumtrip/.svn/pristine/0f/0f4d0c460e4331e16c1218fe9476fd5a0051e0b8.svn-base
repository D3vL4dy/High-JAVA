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
<script src="<%= request.getContextPath() %>/view/js/mypage/mypage_updata.js"></script> 
 
<!-- 로딩중 -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/view/css/fakeLoader.css">
<script src="<%= request.getContextPath() %>/view/js/fakeLoader.js"></script>
</head>
<body>

<header id="header"><!-- 상단 헤더 불러오기 --></header>
<div class="mypage_wrap_topHead">
	<div class="mypage_wrap_tBox">
		마이페이지 > 정보조회 > 프로필수정
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

			
			
				<div class="container join_con">
	  <h2>회원정보수정</h2>
	  
	  
	   <form class="needs-validation needs-validation_wrap" novalidate>
	  
 
	    <div class="form-group">
	      <label for="uname">이름</label>
	      <!--  required => 필수항목
	      placeholder="Enter username" => default text  -->
	      <input type="text" class="form-control control-label col-sm-3" id="uname" placeholder="Enter username" name="mem_name" required>
	      <div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback">Please fill out this field.</div>
	    </div>
	    
	    
	    <div class="form-group">
	      <label for="pwd">비밀번호</label>
	      <input type="password" class="form-control control-label col-sm-3" id="pwd" placeholder="Enter password" name="mem_pass" required>
	      <div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback">Please fill out this field.</div>
	    </div>
	    <div class="form-group">
	      <label for="pwd">비밀번호 확인</label>
	      <input type="password" class="form-control control-label col-sm-3" id="pwd2" placeholder="Enter password" required>
	      <div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback">Please fill out this field.</div>
	   	  <div class="passMiss"></div>
	    </div>

	    <!-- 휴대폰  -->
	    <div class="form-group">
	      <label for="phon"> 휴대폰번호 </label>
	      <!--  required => 필수항목
	      placeholder="Enter username" => default text  -->
	      <input type="text" class="form-control control-label col-sm-3" id="phon" placeholder="010-1234-5678" name="mem_tel" required>
	      <div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback">Please fill out this field.</div>
	    </div>
	    <!--우편번호 -->
	 	<div class="form-group">
	 		<label for="uzip">우편번호</label>
	 		
	 	 	<input id="member_post"  type="text" class="form-control control-label col-sm-3" placeholder="Zip Code" readonly onclick="findAddr()">
			<button type="button" id="zipserach" class="btn btn-info mb-2 mr-sm-2" data-toggle="modal" data-target="#myModal" onclick="findAddr()"> 번호검색 </button>
	 	 </div>
	 	 <div class="form-group">
	 	 	<label for="uadd1">주소</label>
	  		<input id="member_addr" type="text" class="form-control control-label col-sm-3" placeholder="Address" readonly>
	  	 </div>
	  	<div class="form-group">
	    <label for="add3">상세주소</label>
	  		<input type="text" class="form-control control-label col-sm-3" placeholder="Detailed Address" id="member_addr2" required>
	  		<div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback">Please fill out this field.</div>
	  	</div>
	    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	    	
	    
	    <button type="submit" class="btn btn-primary btn-sm btn-block joincheck" id="joincheck" >Submit</button>
	    <span id="joinspan"></span>
	    
	  </form>
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