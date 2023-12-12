<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

1. hero : <c:out value="${hero}"/> <br>
2. hero : <c:out value="${sessionScope.hero}"/> <br>

<c:remove var="hero" scope="request"/>
3. hero : <c:out value="${hero}"/> <br>