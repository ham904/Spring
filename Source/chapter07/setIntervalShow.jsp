<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.println("name : " + session.getAttribute("name") + "<BR>");
	out.println("nation : " + session.getAttribute("nation") + "<BR>");
	out.println("세션의 지속시간 : " + session.getMaxInactiveInterval());
%>