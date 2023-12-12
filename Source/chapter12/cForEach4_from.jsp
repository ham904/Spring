<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*" %>
<%@ page import="chapter12.*" %>

<%
	ArrayList<StudentBean> studentList = new ArrayList<StudentBean>();

	StudentBean st1 = new StudentBean("홍길동", "hong@abcd.com");  
	StudentBean st2 = new StudentBean("이순신", "leeg@abcd.com"); 

	studentList.add(st1);
	studentList.add(st2);	
%>

<c:set var="studentList" value="<%=studentList%>" scope="request" />

<jsp:forward page="cForEach4_to.jsp" />