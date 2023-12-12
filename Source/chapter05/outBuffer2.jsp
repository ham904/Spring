<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.println("1-첫 번째 문장입니다.<br>");
	out.println("2-두 번째 문장입니다.<br>");

	out.clearBuffer();
	
	out.println("3-세 번째 문장입니다.<br>");
	out.println("4-네 번째 문장입니다.<br>");

	out.close();
	
	out.println("5-다섯 번째 문장입니다.<br>");
%>