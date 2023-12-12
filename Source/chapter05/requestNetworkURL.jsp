<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.println("프로토콜 정보 : " + request.getProtocol() + "<br>");
	out.println("클라이언트 IP : " + request.getRemoteAddr() + "<br>");
	out.println("서버 이름 : " + request.getServerName() + "<br>");
	out.println("요청 방식 : " + request.getMethod() + "<br>");
	out.println("URL 정보 : " + request.getRequestURL() + "<br>");
	out.println("애플리케이션 경로 : " + request.getContextPath() + "<br>");
	out.println("서블릿 경로 : " + request.getServletPath() + "<br>");
%>