<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="eng">${param.eng}</c:set>
<c:set var="math" value="${param.math}"/>
<c:set var="average" value="${(math+eng)/2}" scope="request"/>

<jsp:forward page="cSet1_to.jsp"/>
