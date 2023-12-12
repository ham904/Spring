<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="str" value="I love you and you love me."/>


 1.문자열열길이(length)				: ${fn:length(str)} <br>
 2.대문자변환(toUpperCase)			: ${fn:toUpperCase(str)} <br> 
 3.문자열 추출(subString)			: ${fn:substring(str, 7, 10)} <br>
 4.문자열 추출(subStringAfter) 		: ${fn:substringAfter(str,"and")} <br>
 5.문자열 추출(subStringBefore)		: ${fn:substringBefore(str,"and")} <br>  
 6.문자열 대치(replace) 			: ${fn:replace(str,"love","like")} <br>  
 7.문자 위치(indexOf) 				: ${fn:indexOf(str,"you")} <br>
 8.문자열 시작(startsWith)			: ${fn:startsWith(str,"I")} <br>
 9.문자열 끝(endsWith)				: ${fn:endsWith(str,"I")} <br> 
10.문자열 포함(contains)			: ${fn:contains(str,"love")} <br> 
11.문자열 포함(containsIfnoreCase)	: ${fn:containsIgnoreCase(str,"i")} <br>

12.문자열을 배열로(split) :  
<c:set var="myStr" value="korea,china,japan" />

<c:set var="arr" value="${fn:split(myStr, ',')}" />
<c:forEach var="item" items="${arr}">
	${item} &nbsp;
</c:forEach>
<br>

13.배열을 문자열로(join) 			: ${fn:join(arr,"-")} <br> 
  