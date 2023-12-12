<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// JSP를 이용한 출력
	out.println(request.getAttribute("city"));
	out.println("<br");
%>

<!-- 영역 내장 객체를 생략한 경우 -->
1. ${city} <br>

<!-- 우선순위에 의한 session 영역의 속성 출력 -->
2. ${nation} <br>

<!-- 영역 내장 객체를 지정한 속성 출력 -->
3. ${applicationScope.nation}