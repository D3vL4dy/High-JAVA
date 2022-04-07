<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax를 이용한 json데이터 처리하기</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		// 문자열 처리
		$('#strBtn').on('click', function(){
			$.ajax({
				url : '<%=request.getContextPath()%>/jsonController.do',
				type: 'post',
				data : 'choice=string',
				success : function(data){ // 응답데이터 처리
					var str = "문자열 데이터<hr>";
					str += data;
					$('#result').html(str);
				},
				error : function(){
					alert("오류");
				},
				dataType : 'json' // 응답으로 오는 데이터의 종류 설정
			});
		});
		
		// 배열 처리
		$('#arrayBtn').on('click', function(){
			$.ajax({
				url : '<%=request.getContextPath()%>/jsonController.do',
				type: 'post',
				data : 'choice=array',
				success : function(data){ // 응답데이터 처리
					let str = "배열 데이터<hr>";
					$.each(data, function(i, v){
						str += i + "번째 데이터 : " + v + "<br>";
					});
					
					$('#result').html(str);
				},
				error : function(){
					alert("오류");
				},
				dataType : 'json' // 응답으로 오는 데이터의 종류 설정
			});
		});
		
		// 객체 처리
		$('#objBtn').on('click', function(){
			$.ajax({
				url : '<%=request.getContextPath()%>/jsonController.do',
				type: 'post',
				data : 'choice=object',
				success : function(data){ // 응답데이터 처리
					// { "num" : 100, "name" : "홍길동", "tel" : "010-1234-5678" }
					let str = "객체 데이터<hr>";
					// function(data)에서 data. 으로 접근해야 값을 얻을 수 있음
					str += "번호 : " + data.num + "<br>"; // 100
					str += "이름 : " + data.name + "<br>"; // 홍길동
					str += "전화번호 : " + data.tel + "<br>"; // 010-1234-5678
					
					$('#result').html(str);
				},
				error : function(){
					alert("오류");
				},
				dataType : 'json' // 응답으로 오는 데이터의 종류 설정
			});
		});
		
		// 리스트 처리 (자바의 List는 JSON에서는 배열로 변환된다.)
		$('#listBtn').on('click', function(){
			$.ajax({
				url : '<%=request.getContextPath()%>/jsonController.do',
				type: 'post',
				data : 'choice=list',
				success : function(data){ // 응답데이터 처리
					// [ { "num" : 100, "name" : "홍길동", "tel" : "010-1234-5677" },
					//	 { "num" : 200, "name" : "홍길서", "tel" : "010-1234-5688" },
					//   { "num" : 300, "name" : "홍길남", "tel" : "010-1234-5699" } ]
					let str = "리스트 데이터<hr>";
					$.each(data, function(i, v){ // v => data
						str += i + "번째 자료<br>";
						str += "번호 : " + v.num + "<br>";
						str += "이름 : " + v.name + "<br>";
						str += "전화번호 : " + v.tel + "<br><hr>";
					})
					$('#result').html(str);
				},
				error : function(){
					alert("오류");
				},
				dataType : 'json' // 응답으로 오는 데이터의 종류 설정
			});
		});
		
		// Map 처리 (자바의 Map은 JSON에서는 객체형으로 변환된다.)
		$('#mapBtn').on('click', function(){
			$.ajax({
				url : '<%=request.getContextPath()%>/jsonController.do',
				type: 'post',
				data : 'choice=map',
				success : function(data){ // 응답데이터 처리
					// { key값1:value값1, key값2:value값2, ...}
					let str = "Map 데이터<hr>";
					str += "name : " + data.name + "<br>";
					str += "tel : " + data.tel + "<br>";
					str += "addr : " + data.addr + "<hr>";
					
					$.each(data, function(i, v){
						// data가 객체형이면 i에는 변수명, v에는 데이터값이 저장된다.
						str += i + " ==> " + v + "<br>";
					});
					
					$('#result').html(str);
				},
				error : function(){
					alert("오류");
				},
				dataType : 'json' // 응답으로 오는 데이터의 종류 설정
			});
		});
		
	});
</script>
</head>
<body>
	<form>
		<input type="button" id="strBtn" value="문자열">
		<input type="button" id="arrayBtn" value="배열">
		<input type="button" id="objBtn" value="객체">
		<input type="button" id="listBtn" value="리스트">
		<input type="button" id="mapBtn" value="Map객체">
	</form>
	<hr>
	<h3>응답 결과 출력</h3>
	<div id="result"></div>
</body>
</html>