<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	out.println("첫 번째 문장입니다.<hr>");	
%>

<jsp:include page="at_includeParamTo.jsp">
	<jsp:param value="홍길동" name="name"/>
	<jsp:param value="hong" name="id"/>
</jsp:include>

<%
	out.println("<hr>마지막 문장입니다");	
%>
