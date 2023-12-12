<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="chapter08.*" %>

<!-- studentController.jsp에서 전달된 studentList를 빈즈로 생성 -->
<jsp:useBean id="studentList" class="java.util.ArrayList" scope="request"/> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">	
</head>
<body>

	<h3 align=center>학생 정보 출력</h3>
	<hr align=center width=620 noshade>
	
	<table class=main>
	
		<tr align=center>
			<td class=title1 width=90>아이디</td>
			<td class=title1 width=90>이름</td>
			<td class=title1 width=150>학과</td>
			<td class=title1 width=60>등급</td>
			<td class=title1 width=60>점수</td>
			<td class=title1 width=50>수정</td>
			<td class=title1 width=50>삭제</td>						
		</tr>
		
		<!-- 순환문을 사용해 student 빈즈로부터 레코드를 출력-->
		<% 
			for( StudentVO st : (ArrayList<StudentVO>) studentList ) { 
		%>		
		<tr>
			<td class=content1><%=st.getId()%></td>
			<td class=content1><%=st.getName() %></td>
			<td class=content1><%=st.getDepart() %></td>
			<td class=content1><%=st.getGrade() %></td>
			<td class=content1><%=st.getScore() %></td>
			<td class=content1>
				<a href="studentController.jsp?action=choose&sID=<%=st.getId() %>">수정</a>
			</td>
			<td class=content1>
				<a href="studentController.jsp?action=delete&sID=<%=st.getId() %>">삭제</a>
			</td>
		</tr>	
		<%
			}
		%>	
	
	</table>
	
	<table align=center>
		<tr>
			<td align=center>
				<input type=button value="INSERT" onClick="location.replace('studentInput.jsp')">
			</td>
		</tr>
	</table>
	
</body>
</html>