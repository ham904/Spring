<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="site" value="cRedirect_to.jsp">
	<c:param name="name">이순신</c:param>
	<c:param name="age">26</c:param>
</c:url>

<c:redirect url="${site}"/>