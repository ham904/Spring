<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date " %>

<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h3>숫자 출력</h3>
<fmt:formatNumber value="10000" type="number" groupingUsed="true" /> <br>
<fmt:formatNumber value="123.4567" type="number"  pattern="#.000"/><br>
<fmt:formatNumber value="0.5" type="percent" />

<h3>통화 출력</h3>
<fmt:formatNumber value="10000" type="currency" groupingUsed="true" /> <br>
<fmt:formatNumber value="10000" type="currency" currencyCode="USD"/> <br>
<fmt:formatNumber value="10000" type="currency" groupingUsed="true" currencySymbol="$" /> <br>