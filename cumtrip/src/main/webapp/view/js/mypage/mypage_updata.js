/**
 * 
 */
  	//카카오 우편번호 검색
	
	
	function findAddr(){
	   new daum.Postcode({
	        oncomplete: function(data) {
	           
	           console.log(data);
	           
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var roadAddr = data.roadAddress; // 도로명 주소 변수
	            var jibunAddr = data.jibunAddress; // 지번 주소 변수
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('member_post').value = data.zonecode;
	            if(roadAddr !== ''){
	                document.getElementById("member_addr").value = roadAddr;
	            } 
	            else if(jibunAddr !== ''){
	                document.getElementById("member_addr").value = jibunAddr;
	            }
	        }
	    }).open();
	}
 
 
  $(function(){
	$('form').on('submit', function(){
		
		add1 = $('#member_post').val().trim();
		add2 =$('#member_addr').val().trim();
		add3 = $('#member_addr2').val().trim();
		
		uname = $('#uname').val().trim();
		pwd = $('#pwd').val().trim();
		pwd2 = $('#pwd2').val().trim();
		phon = $('#phon').val().trim();
		add = add1+" "+add2+" "+add3;
		
		
		if(uname.length == 0 || pwd.length == 0 || phon.length == 0
		|| add2.length == 0 || add3.length == 0 || pwd != pwd2){
			if(uname.length == 0) alert("이름은 비워둘수 없습니다.");
			if(pwd.length == 0) alert("패스워드는 비워둘수 없습니다.");
			if(phon.length == 0) alert("전화번호는 비워둘수 없습니다.");
			if(add2.length == 0) alert("주소는 비워둘수 없습니다.");
			if(add3.length == 0) alert("상세 주소를 입력해주세요.");
			if(pwd != pwd2) alert("패스워드가 서로 다릅니다.");
		}else{
				$.ajax({
					url: '/cumtrip/Mypage_update.do',
					data: {
						"mem_name" : uname,
						"mem_pass" : pwd,
						"mem_addr" : add,
						"mem_tel" : phon
						
					},
					type: 'post',
					success: function(res){
						alert("업데이트 성공!");
		/*				if(res.sou == "1"){
						alert("업데이트 성공!");
						location.href = "mypage_index.jsp";	
							
						}else{
						alert("업데이트 실패");
						location.href = "mypage_index.jsp";	
							
						}*/
						
					},
					error: function(xhr){
						alert("상태: "+xhr.status);
						if(xhr.status == 500){ 
							alert("로그인 상태가 아닙니다.");
							location.href = "../index.jsp" };
					},
					dataType: 'json'
				})
		}
		

	})
	
})