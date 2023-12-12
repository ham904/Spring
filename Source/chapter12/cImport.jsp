<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h3>이 부분은 cImport.jsp 문서의 상단입니다.</h3>
<hr>

<c:import url="cRedirect_to.jsp">
	<c:param name="name">강감찬</c:param>
	<c:param name="age">29</c:param>
</c:import>

<hr>
<h3>이 부분은 cImport.jsp 문서의 하단입니다.</h3>