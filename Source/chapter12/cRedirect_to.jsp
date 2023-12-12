<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="name" value="${param.name}"/>
<c:set var="age" value="${param.age}"/>

이름 : <c:out value="${name}"/> <br>
나이 : <c:out value="${age}"/>