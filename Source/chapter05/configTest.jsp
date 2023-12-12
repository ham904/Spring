<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String nation = config.getInitParameter("nation");
	String name = config.getInitParameter("name");
	String servletName = config.getServletName();
	
	out.println("nation : " + nation + "<br>");	
	out.println("name : " + name +"<br>");
	out.println("servletName : " + servletName);
	
	
%>