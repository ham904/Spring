<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	session.setAttribute("number", 1234);
	session.setAttribute("name", "홍길동");

	response.sendRedirect("getAttr1.jsp");	

%>