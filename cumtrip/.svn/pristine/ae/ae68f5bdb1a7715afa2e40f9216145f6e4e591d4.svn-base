<%@page import="cumtrip.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="haederTop">
	<a href="./index.jsp" class="logolink"><img src="../images/logo.svg" ></a>
	<nav class="navbar navbar-expand-sm navbar-info">
	   	
	  <form class="form-inline">
	  
	   <select class="form-control" id="stype">
	   		<option value="">전체</option>
	   		<option value="subject">제목</option>
	   		<option value="writer">작성자</option>
	   		<option value="content">내용</option>
	   	</select>
   	
	    <!-- <input id="sword" class="form-control mr-sm-2" type="text" placeholder="Search">
	    <button id="search" class="btn btn-primary" type="button">Search</button> -->
	  </form>
	</nav>

<% 
	//JSP문서에서 세션은 'session'이라는 이름으로 이미 생성되어 있다.
	List<MemberVO> loginMemVo = (List<MemberVO>)session.getAttribute("loginMember");

%>

<!-- 로그인시작 -->
<% if(loginMemVo == null || loginMemVo.size() == 0 ){ //로그인관련 세션이 없을때 %>
<!-- 로그인시작 -->
	<a data-toggle="modal" href="#loginModal" id="top_login">LOGIN</a>
	  <div class="modal fade" id="loginModal" role="dialog">
	   <div class="modal-dialog">
	    <div class="modal-content">
	     <div class="modal-header">
	      <h1 class="modal-title" align="center">로그인</h1>
	      <button type="button" class="close" data-dismiss="modal">×</button>
	
	     </div>
	     <div class="modal-body">
	         <!-- 본문시작 -->
		      <form id="login_form" action="<%= request.getContextPath() %>/sessionLogin.do" method="get">
		      	<label for="id">ID</label><input type="text" class="form-control" id="id" name="memid" placeholder="id"><br>
		      	<label for="pass">PASS</label><input type="text" class="form-control" id="pass" name="mempass" placeholder="pass"><br>
		      	<input type="submit" value="확인" id="login_button"  class="btn btn-dark"><br><br>
		      	<a href="./findID.jsp">아이디 찾기</a>
		      	<a href="./findPass.jsp">비밀번호 찾기</a>
		      	<a href="./singIn.jsp">회원가입</a>
		      </form>
	     </div>
	    </div>
	   </div>
	  </div>
	  
	  <!-- 로그인 마침 -->
  
  	<a href="./singIn.jsp" class="topButton" id="SignUp">회원가입</a>
  	
<%	}else{  //로그인관련 세션이 있을때(로그인이 되었을때)
		for(MemberVO vo : loginMemVo){
%>
	<h3 class="successID"><%= vo.getMem_email() %>님 반갑습니다</h3>
<% 
	}
%>	
	<a href="<%= request.getContextPath() %>/sessionLogout.do" class="logoutButton">로그아웃</a>
<%	
}
%>

  	
</div>
	
	
	<nav class="top_menu">
	<a href="./index1.html">관광명소</a>
	<a href="#">음식점</a>
	<a href="#">숙소</a>
	</nav>