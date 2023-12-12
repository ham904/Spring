<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setAttribute("city", "seoul");
	session.setAttribute("nation", "korea");
	application.setAttribute("nation", "france");
%>

<jsp:forward page="scopeTo.jsp"/>
	