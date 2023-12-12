<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int number = (int)session.getAttribute("number");
	String name = (String)session.getAttribute("name");
	
	out.println("번호 : " + number + "<br>");
	out.println("이름 : " + name);	

%>