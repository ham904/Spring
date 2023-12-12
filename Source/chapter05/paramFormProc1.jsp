<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%
	//POST 방식으로 전달된 데이터의 인코딩 문자집합 지정
	request.setCharacterEncoding("utf-8");
	
	//전달된 파라미터 추출
	String depart = request.getParameter("depart");
	int num = Integer.parseInt(request.getParameter("num"));
	String user = request.getParameter("user");
	float score = Float.parseFloat(request.getParameter("score"));
	
	//추출한 파라미터 브라우저 출력
	out.println("학과 : " + depart + "<br>");
	out.println("학번 : " + num + "<br>");
	out.println("이름 : " + user + "<br>");
	out.println("평점 : " + score + "<br>");

%>