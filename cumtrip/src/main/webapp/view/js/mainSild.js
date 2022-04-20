	$(function() {
		// 관광지 1-9
		$.ajax({
			url : '/cumtrip/TourListUpload1.do',
			type : 'get',
			
			success : function(res) {
				$.each(res, function(i, v) {
					if (i < 3) {
						str = "<span>";
						str += '<a href="detailpage.jsp?midno='+v.mid_no+'"><img src="/cumtrip/TourList.do?filename=' + v.photo_path + '" alt="' + v.photo_path + '" ></a>';
						str += '<h5>' + v.mid_name + '</h5>';
						str += '<b>' + v.main_cate + '</b></span>';
						$('#t1').append(str);
					} else if (i < 6) {
						str = "<span>";
						str += '<a href="detailpage.jsp?midno='+v.mid_no+'"><img src="/cumtrip/TourList.do?filename=' + v.photo_path + '" alt="' + v.photo_path + '" ></a>';
						str += '<h5>' + v.mid_name + '</h5>';
						str += '<b>' + v.main_cate + '</b></span>';
						$('#t2').append(str);

					} else if (i < 9) {
						str = "<span>";
						str += '<a href="detailpage.jsp?midno='+v.mid_no+'"><img src="/cumtrip/TourList.do?filename=' + v.photo_path + '" alt="' + v.photo_path + '" ></a>';
						str += '<h5>' + v.mid_name + '</h5>';
						str += '<b>' + v.main_cate + '</b></span>';
						$('#t3').append(str);
					} 
				})
			},
			error : function(xhr) {
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
		})
		
 		// 관광지 10-18
		$.ajax({
			url : '/cumtrip/TourListUpload2.do',
			type : 'get',
			
			success : function(res) {
				$.each(res, function(i, v) {

					if (i < 3) {
						str = "<span>";
						str += '<a href="detailpage.jsp?midno='+v.mid_no+'"><img src="/cumtrip/TourList.do?filename=' + v.photo_path + '" alt="' + v.photo_path + '" ></a>';
						str += '<h5>' + v.mid_name + '</h5>';
						str += '<b>' + v.main_cate + '</b></span>';
						$('#s1').append(str);
					} else if (i < 6) {
						str = "<span>";
						str += '<a href="detailpage.jsp?midno='+v.mid_no+'"><img src="/cumtrip/TourList.do?filename=' + v.photo_path + '" alt="' + v.photo_path + '" ></a>';
						str += '<h5>' + v.mid_name + '</h5>';
						str += '<b>' + v.main_cate + '</b></span>';
						$('#s2').append(str);

					} else if (i < 9) {
						str = "<span>";
						str += '<a href="detailpage.jsp?midno='+v.mid_no+'"><img src="/cumtrip/TourList.do?filename=' + v.photo_path + '" alt="' + v.photo_path + '" ></a>';
						str += '<h5>' + v.mid_name + '</h5>';
						str += '<b>' + v.main_cate + '</b></span>';
						$('#s3').append(str);
					} 
				})
			},
			error : function(xhr) {
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
		})
		
		// 관광지 19-27
		$.ajax({
			url : '/cumtrip/TourListUpload3.do',
			type : 'get',
			
			success : function(res) {
				$.each(res, function(i, v) {
					if (i < 3) {
						str = "<span>";
						str += '<a href="detailpage.jsp?midno='+v.mid_no+'"><img src="/cumtrip/TourList.do?filename=' + v.photo_path + '" alt="' + v.photo_path + '" ></a>';
						str += '<h5>' + v.mid_name + '</h5>';
						str += '<b>' + v.main_cate + '</b></span>';
						$('#f1').append(str);
					} else if (i < 6) {
						str = "<span>";
						str += '<a href="detailpage.jsp?midno='+v.mid_no+'"><img src="/cumtrip/TourList.do?filename=' + v.photo_path + '" alt="' + v.photo_path + '" ></a>';
						str += '<h5>' + v.mid_name + '</h5>';
						str += '<b>' + v.main_cate + '</b></span>';
						$('#f2').append(str);

					} else if (i < 9) {
						str = "<span>";
						str += '<a href="detailpage.jsp?midno='+v.mid_no+'"><img src="/cumtrip/TourList.do?filename=' + v.photo_path + '" alt="' + v.photo_path + '" ></a>';
						str += '<h5>' + v.mid_name + '</h5>';
						str += '<b>' + v.main_cate + '</b></span>';
						$('#f3').append(str);
					} 
				})
			},
			error : function(xhr) {
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
		})
		 
	})
