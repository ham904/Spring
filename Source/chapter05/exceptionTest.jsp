<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try {
		
		int a=20;
		int b=0;
		int c = a/b;
		
	} catch(Exception e) {
		
		out.println(e.toString());
		
	}
%>