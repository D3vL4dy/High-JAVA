$(function(){
	
	//아이디찾기
	
	$('#find_id_form').on('submit',function(){
		
		find_name = $('#find_name').val().trim();
		find_tel = $('#find_tel').val().trim();
		if(find_name.length == 0 || find_name.length == null ||
		find_tel.length == 0 || find_tel.length == null){
			if(find_name.length == 0 || find_name.length == null){
				alert("이름을 입력해주세요");
			}
			if(find_name.length == 0 || find_name.length == null){
				alert("전화번호를 입력해주세요");
			}	
		}else{
			
			$.ajax({
			url : '/cumtrip/FindIDpass.do',
			data: { 
				"flag" : 1,
				"find_name": find_name,
				"find_te" : find_tel
			 },
			type: 'post',
			success: function(res){
				alert("아이디는 "++"입니다");
			},
			error: function(vhr){
				alert("상태: "+vhr.status)
			},
			dataType: 'json'
			
		})
		
		}
		
		
		return false;
		
	})
	
	
})





