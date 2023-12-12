<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="en_us"/>

<fmt:setBundle basename="member"/>

<b> name : </b> <fmt:message key="name"/>
<br>

<b> depart : </b> <fmt:message key="depart"/>
<br>

<b> job : </b> <fmt:message key="job"/>
<br>