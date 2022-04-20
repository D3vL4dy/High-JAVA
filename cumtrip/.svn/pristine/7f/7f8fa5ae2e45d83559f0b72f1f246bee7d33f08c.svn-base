 $(function(){
	$('#delete_member').on('click', function(){
		
		$.ajax({
			url: '/cumtrip/Mypage_delete.do',
			type: 'post',
			success: function(res){
				if(res.sou == "1"){
				alert("탈퇴 성공!");
				location.href = "../../../sessionLogout.do";	
					
				}else{
				alert("탈퇴실패");
				location.href = "../../../sessionLogout.do";
				}
				
			},
			error: function(xhr){
				alert("상태: "+xhr.status);
				if(xhr.status == 500){ 
					alert("로그인 상태가 아닙니다.");
					location.href = "../index.jsp" };
			},
			dataType: 'json'
		})
	})
	
	
	$('#reset_delete').on('click', function(){
		location.href = "mypage_index.jsp";
	})
	
	
})