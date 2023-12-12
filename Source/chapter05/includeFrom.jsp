<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	out.println("includeFrom.jsp 문서의 내용입니다.");
	pageContext.include("includeSub.jsp");	
%>