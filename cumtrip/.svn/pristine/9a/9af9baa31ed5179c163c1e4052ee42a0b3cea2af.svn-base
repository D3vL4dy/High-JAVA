<%@page import="cumtrip.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

MemberVO id = (MemberVO)request.getAttribute("idFind");


if(id == null){

%>

	{
		"flag" : "존재하지 않는 회원이거나 입력값이 일치하지 않습니다.",
		"status" : "0"
	}


	<% } else{ %>

	{
		"flag" : "존재하는 회원입니다.",
		"sendMail" : "<%= id.getMem_email() %>",
		"status" : "1"
	}

<%  } %>
