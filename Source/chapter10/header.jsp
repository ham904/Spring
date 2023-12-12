<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// JSP를 이용한 헤더 출력
	out.print("Host : " + request.getHeader("Host") + "<br>");
	out.print("accept-encoding : " + request.getHeader("accept-encoding") + "<br>");
%>

<!-- 표현언어를 이용한 헤더 출력 -->
Host : ${header.Host}
<br>
accept-encoding : ${header["accept-encoding"]}
