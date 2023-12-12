<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	int num1=10;
	int num2=0;
%>
<c:catch var="e">
	<% int result = num1/num2; %>
</c:catch>

<c:if test="${e != null}" >
	errors : ${e.message}
</c:if>