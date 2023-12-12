<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
    
<%

	Enumeration<String> param = application.getInitParameterNames();

	while( param.hasMoreElements() ) {
		String paramName = param.nextElement();
		String paramValue = application.getInitParameter(paramName);
		
		out.println(paramName + " : " + paramValue + "<br>");
	}	
	
%>