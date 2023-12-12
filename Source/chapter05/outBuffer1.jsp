<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if( out.isAutoFlush() ) {
		out.println("현재 버퍼의 크기 : " + out.getBufferSize() + "<br><br>" );
		out.println("Happy Birthday to you.<br><br>");
		out.println("현재 버퍼에 남아있는 크기 : " + out.getRemaining() + "<br><br>");
	}
		
	out.println("flush를 수행합니다. 현재까지 버퍼의 내용이 출력됩니다.<br><hr><br>");
	out.flush();	

	out.println("현재 버퍼에 남아있는 크기 : " + out.getRemaining() + "<br><br>");
%>