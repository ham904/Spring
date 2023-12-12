<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="scriptless" %>
<%@ tag import="java.util.Map" %>

<%@ tag dynamic-attributes="attrs" %>

<jsp:doBody var="str" scope="page" />

<font color=${attrs.color}>
	
<%
	Map attrSet = (Map)jspContext.getAttribute("attrs");
	
	String str = (String)jspContext.getAttribute("str"); 	
	String strUpper = str.toUpperCase();
	
	int count = Integer.parseInt((String)attrSet.get("count"));

	for( int i=0; i<count; i++) {
		out.print(strUpper + " ");
	}
	out.print("<br>");	

%>

</font>
