<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="scriptless" %>

<jsp:doBody var="str" scope="page" />

<%
	
	PageContext context = (PageContext)this.getJspContext();
	String str = (String)context.getAttribute("str");
	
	String strUpper = str.toUpperCase();

	for( int i=0; i<3; i++) {
		out.print(strUpper + " ");
	}
	out.print("<br>");	
	
%>