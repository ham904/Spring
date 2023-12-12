<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%

	String fname = "mydata.txt";

	char[] buff = new char[512];
	int length = -1;
	
	InputStreamReader isr = new InputStreamReader(application.getResourceAsStream(fname));
	BufferedReader br = new BufferedReader(isr);
	
	while((length = br.read(buff)) != -1) {
		out.println(new String(buff, 0, length));
	}	
	br.close();
	isr.close();
	
%>