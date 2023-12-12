<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Cookie cookie1 = new Cookie("userName", "hong");
	response.addCookie(cookie1);
	
	Cookie cookie2 = new Cookie("user-pw", "hongpass");
	response.addCookie(cookie2);
	
	response.sendRedirect("cookieTo.jsp");
%>