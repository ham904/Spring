<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("utf-8"); %>
    
<jsp:forward page="at_fwrdParamTo.jsp">
	<jsp:param value="홍길동" name="name"/>
	<jsp:param value="25" name="age"/>
</jsp:forward>