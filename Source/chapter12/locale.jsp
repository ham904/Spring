<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.TimeZone" %>

<%
	String timezone[] = TimeZone.getAvailableIDs();
	for( int i=0; i<timezone.length; i++ ) {
		out.println(timezone[i] + "<br>");
	}
%>