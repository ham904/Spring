<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String uid = request.getParameter("uid");
	out.println("아이디 : " + uid + "<br>");	
%>

<jsp:include page="at_includeReqTo.jsp"/>

<% 
	String uname = request.getParameter("uname");
	out.println("이름 : " + uname);	
%>
