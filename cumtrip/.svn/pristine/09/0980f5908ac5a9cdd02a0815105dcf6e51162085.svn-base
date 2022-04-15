<%@page import="cumtrip.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
List<MemberVO> id = (List<MemberVO>)request.getAttribute("listvalue");
String sendmail = null;

for(MemberVO vo : id){
	sendmail = vo.getMem_email();
}

if(id.size() == 0){
//사용가능
%>

{
	"flag" : "사용가능!",
	"sendMail" : "<%=sendmail%>"
}


<% } else{ %>

{
	"flag" : "사용불가!"
}

<%  } %>