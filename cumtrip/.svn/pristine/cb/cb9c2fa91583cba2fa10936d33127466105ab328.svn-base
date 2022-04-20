<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%    
    request.setCharacterEncoding("UTF-8");
    String mem_mail = request.getParameter("mem_mail");
%>

<!DOCTYPE html>
<html>
<head>
<title>CUM TRIP</title>
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


<script> 
$(function() {
	console.log("안녕");
	alert("헬로");
	
	//비밀번호 변경
	$('#find_passSet_form').on('submit', function(){
		//setPassMail = $('.passSet_NameSpan').val().trim();
		set_passWord = $('#set_passWord').val().trim();
		set_passWord2 = $('#set_passWord2').val().trim();
		
			if(set_passWord != set_passWord2 || set_passWord.length == 0 || set_passWord2.length == 0){	
				if(set_passWord != set_passWord2){ alert("비밀번호가 일치하지 않습니다."); }
				if(set_passWord.length == 0 || set_passWord2.length == 0){ alert("비밀번호는 공백일 수 없습니다."); }
			}else{
				$.ajax({
						url : '/cumtrip/FindIDpass.do',
						data: { 
							"flag" : 3,
							"setPassMail": <%=request.getParameter("mem_mail")%>,
							"set_passWord" : set_passWord
						 },
						type: 'post',
						success: function(res){
							alert(res.flag);
							location.href ="index.jsp";
						
						},
						error: function(vhr){
							alert("상태: "+vhr.status)
						},
						dataType: 'json'
						
					})
					
			}
			//return false;
		
		})
})

</script>
</head>
<body>
	<header id="header"><!-- 상단 헤더 불러오기 --></header>
	<contain>
		<div class="Page_rwrap">
			<h3>CUM TRIP</h3>
			<h1>비밀번호 변경</h1>
			<div class="passSet_Name"><span class="passSet_NameSpan"><%= mem_mail %></span>님의 비밀번호를 변경합니다.</div>
			<div class="Page_p">변경할 비밀번호를 입력해주세요.</div>
			<form id="find_passSet_form">
				<label>새 비밀번호</label>
				<input type="text" name="set_passWord" id="set_passWord"><br>
				<label>새 비밀번호 재입력</label>
				<input type="text" id="set_passWord2"><br>
				<div class="passSet_box"></div>
				<input type="submit" value="비밀번호변경" id="bo">
			</form>
		</div>
	</contain>
	<footer id="footer"><!-- 하단불러오기 --></footer>
	
	

<!-- 로딩 -->
 <div class="fakeLoader"></div>
 <script src="<%= request.getContextPath() %>/view/js/fakeLoader_speed.js"></script>
	
	
</body>
</html>