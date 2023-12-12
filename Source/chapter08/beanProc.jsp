<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="student" class="chapter08.StudentVO" scope="request" />

<jsp:setProperty property="*" name="student" />

<jsp:forward page="beanView.jsp" />