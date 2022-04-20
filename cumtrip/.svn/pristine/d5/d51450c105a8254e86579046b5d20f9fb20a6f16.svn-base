<%@page import="cumtrip.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

List<MemberVO> list = (List<MemberVO>)request.getAttribute("res1");

if(list.size() == 0){
%>
{
	"status" : "0"
}


<% 
}else{
%>
[
<% 
		for(int i=0; i<list.size(); i++){
		MemberVO vo = list.get(i);
		if(i>0){ out.print(","); } 
			
%>
			

	{
		"sre_no" : "<%= vo.getSre_no() %>", 
		"sre_title" : "<%= vo.getSre_title() %>", 
		"sre_date" : "<%= vo.getSre_date() %>", 
		"sre_point" : "<%= vo.getSre_point() %>"
	}

<%  
} 
%>
] 

<% } %>