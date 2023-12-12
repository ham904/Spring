<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="scriptless" %>

<%@ attribute name="color" required="true" %>
<%@ attribute name="count" required="true" type="java.lang.Integer" %>

<jsp:doBody var="str" scope="page" />

<font color=${color}>

<%
	String str = (String)jspContext.getAttribute("str");
	String strUpper = str.toUpperCase();

	for( int i=0; i<count; i++) {
		out.print(strUpper + " ");
	}
	out.print("<br>");	

%>

</font>