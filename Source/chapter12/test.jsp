<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ServletContext context = getServletContext();
	String realPath = context.getRealPath("/");
	out.println(realPath);	

%>    