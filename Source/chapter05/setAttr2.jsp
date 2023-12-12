<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 속성 지정
	pageContext.setAttribute("spring", "봄");
	request.setAttribute("summer", "여름");
	session.setAttribute("fall", "가을");
	application.setAttribute("winter", "겨울");

	//속성 추출
	String spring = (String)pageContext.getAttribute("spring");
	String summer = (String)request.getAttribute("summer");
	String fall = (String)session.getAttribute("fall");
	String winter = (String)application.getAttribute("winter");
		
%>	

page 영역 : <%=spring %> <br>
request 영역 : <%=summer %> <br>
session 영역 : <%=fall %> <br>
application 영역 : <%=winter %>  
