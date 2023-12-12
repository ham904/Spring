<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="empty" %>
<%@ tag import="java.util.Calendar" %>


<!-- 커스텀 태그 기능 구현 -->
<%
	Calendar calendar = Calendar.getInstance();
		
	int month = calendar.get(Calendar.MONDAY)+1;
	int date = calendar.get(Calendar.DATE);
	int hour = calendar.get(Calendar.HOUR_OF_DAY);
	int min	= calendar.get(Calendar.MINUTE);
	int sec = calendar.get(Calendar.SECOND);
%>		
		
<font color="blue"> 
	<%=month%>월 <%=date%>일  <%=hour%>시  <%=min%>분  <%=sec%>초 
</font>
<br>
