<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String upw = request.getParameter("upw");
	out.println("패스워드 : " + upw + "<br>");	
%>