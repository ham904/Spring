<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>

<% 
	String depart=URLEncoder.encode("소프트웨어","utf-8"); 
	response.sendRedirect("paramFormProc2.jsp?depart=" + depart);	
%>

</body>
</html>