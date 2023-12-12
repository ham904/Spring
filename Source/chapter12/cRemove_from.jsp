<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="hero" value="이순신" scope="request"/>
<c:set var="hero" value="강감찬" scope="session"/>

<c:set var="friend" value="Tom" scope="request"/>
<c:set var="friend" value="Jerry" scope="session"/>

<jsp:forward page="cRemove_to.jsp"/>