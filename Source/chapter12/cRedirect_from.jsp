<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:redirect url="cRedirect_to.jsp">
	<c:param name="name">${"홍길동"}</c:param>
	<c:param name="age">${25}</c:param>
</c:redirect>
