<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>

<%
	out.print("이름 : " + request.getParameter("username") + "<br>");
%>

메일 : ${param.usermail} <br>

취미(관심분야) :
${paramValues.hobby[0]} 
${paramValues.hobby[1]} 
${paramValues.hobby[2]} 