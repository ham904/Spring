<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	out.println("id : " + session.getAttribute("id") + "<br>");
	out.println("name : " + session.getAttribute("name"));
%>
