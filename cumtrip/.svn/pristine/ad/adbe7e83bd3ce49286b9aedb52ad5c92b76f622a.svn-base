$(function(){
	
	$.ajax({
		url: '/cumtrip/MypageReview.do',
		type: 'post',
		success: function(res){
			
				str = "";
				star = "";
				if(res.status == "0"){
					str += '<h5>데이터가 없습니다</h5>';
					$('.mypage_boxReview_span').html(str);
				}else{
					$.each(res, function(i, v){
						
					        for(let j=0; j<v.sre_point; j++){ star +="★"; }                                                                
							str += '<li class="mypage_boxReview_li">';
							str += '	<div class="m_Review_no">'+v.sre_no+'</div>';
							str += '	<div class="m_Review_title">'+v.sre_title+'</div>';
							str += '	<div class="m_Review_date">'+v.sre_date+'</div>';
							str += '<div class="m_Review_star">'+star+'</div>';
							str += '</li>';
							star = "";
							
					}) 
					
				$('.mypage_boxReview_span').html(str);	
				
				}	                                                                      
	
				
			
		},
		error: function(xhr){
			if(xhr.status == 500){ 
				alert("로그인 상태가 아닙니다.");
				location.href = "../index.jsp" 
				
				}
		},
		dataType: 'json'
	})
	

	
	
	
	
	
	
})