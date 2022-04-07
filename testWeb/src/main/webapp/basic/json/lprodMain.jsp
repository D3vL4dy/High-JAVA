<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lprod 자료 출력</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
   $(function() {
      $("#lprodBtn").on("click", function() {
         $.ajax({ // 비동기방식
            url : "<%=request.getContextPath()%>/lprodList.do",
            type : "post",
            success : function(data) { // 응답데이터
               let htmlCode = "<table border='1'>";
               htmlCode += "<tr><td>Lprod_ID</td>";
               htmlCode += "<td>Lprod_GU</td>";
               htmlCode += "<td>Lprod_NM</td></tr>";
               
               $.each(data, function(i, v) {
                  htmlCode += "<tr><td>" + v.lprod_id + "</td>"; // prod_id는 LprodVO 클래스의 멤버변수에 맞게 작성
                  htmlCode += "<td>" + v.lprod_gu + "</td>";
                  htmlCode += "<td>" + v.lprod_nm + "</td></tr>";
               });
               
               htmlCode += "</table>";
               
               $("#result").html(htmlCode);
               
            },
            error : function() {
               alert("오류");
            },
            dataType : "json" 
         });
      });
      
      $("#lprodBtn2").on("click", function() {
         location.href = "<%=request.getContextPath()%>/lprodList2.do";
      });
   });

</script>

</head>
<body>
<!-- 
   DB의 LPROD테이블의 전체 데이터를 가져와 화면에 출력하시오.
-->
<form>
   <input type="button" id="lprodBtn" value="Lprod자료 가져오기(Ajax)">
   <input type="button" id="lprodBtn2" value="Lprod자료 가져오기(Non Ajax)">
</form>
<h3>Lprod 자료 목록</h3>
<div id="result"></div>

</body>
</html>