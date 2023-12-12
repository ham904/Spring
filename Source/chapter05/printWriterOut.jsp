<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
    
<%
	PrintWriter out2 = response.getWriter();
	out2.println("7단 구구단 출력을 시작합니다.<br>");
	
	for( int i=1; i<=9; i++ ) {
		out.println("7 * " + i + " = " + 7*i + "<br>");
	}

	out2.println("7단 구구단 출력을 마칩니다.<br>");
%>