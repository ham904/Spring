<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="en_us"/>

<fmt:setBundle basename="member"/>
<fmt:message var="na" key="name"/>
<fmt:message var="de" key="depart"/>
<fmt:message var="jo" key="job"/>

<b> name : </b> ${na}
<br>

<b> depart : </b> ${de}
<br>

<b> job : </b> ${jo}