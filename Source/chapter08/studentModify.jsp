<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!-- studentController.jsp에서 request 속성으로 지정한 student 객체를 student 빈즈로 생성 --> 
<jsp:useBean id="student" class="chapter08.StudentVO" scope="request" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">	
</head>
<body>

	<h3 align=center>학생 정보 수정</h3>
	<hr align=center width=320 noshade>

	<form name="modifyForm" method="post" action="studentController.jsp">
		
		<!-- studentController.jsp에 modify 액션 코드와 id 값을 전달 -->
		<input type=hidden name="action" value="modify">
		<input type=hidden name="sID" value="<%=student.getId() %>"> 
		
		<table class=main>
			
			<tr>
				<td class=title2>아이디</td>
				<td class=content2><%=student.getId() %></td>	
			</tr>
	
			<tr>
				<td class=title2>이름</td>
				<td class=content2><%=student.getName() %></td>	
			</tr>
	
			<tr>
				<td class=title2>학과</td>
				<td class=content2>
					<input type=text name="depart" size=20 required value="<%=student.getDepart() %>">
				</td>
			</tr>		
			
			<tr>
				<td class=title2>등급</td>
				<td class=content2>
					<input type=text name="grade" size=5 required value="<%=student.getGrade() %>">
				</td>	
			</tr>
			
			<tr>
				<td class=title2>점수</td>
				<td class=content2>
					<input type=text name="score" size=5 required value="<%=student.getScore() %>">
				</td>	
			</tr>		
			
		</table>
		<hr align=center width=320 size=1 noshade>
		
		<table align=center>
			<tr>
				<td align=center width=320>
					<input type="submit" value="MODIFY"> &nbsp;
					<input type="button" value="CANCEL" onClick="location.replace('studentController.jsp?action=list')">
				</td>
			</tr>	
		</table>
			
	</form>

</body>
</html>