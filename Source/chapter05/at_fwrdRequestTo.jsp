<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String uid = request.getParameter("uid");
	String upw = request.getParameter("upw");
	
	out.println("아 이 디 : " + uid + "<br>");
	out.println("패스워드 : " + upw);
	
%>