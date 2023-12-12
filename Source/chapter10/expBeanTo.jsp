<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="chapter10.*" %>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="expBean" class="chapter10.ExpBean"/>
<jsp:setProperty property="*" name="expBean"/>

<b> Getter를 이용한 추출 </b> <br>
아이디 : <%=expBean.getUserId() %> <br>
이름 : <%=expBean.getUserName() %> <br>
메일 : <%=expBean.getUserMail() %> <br><br>

<b> 액션 태그를 이용한 추출 </b> <br>
아이디 : <jsp:getProperty property="userId" name="expBean"/> <br>
이름 : <jsp:getProperty property="userName" name="expBean"/> <br>
메일 : <jsp:getProperty property="userMail" name="expBean"/> <br><br>

<b> 표현 언어를 이용한 추출 </b> <br>
아이디 : ${expBean.userId} <br>
이름 : ${expBean.userName} <br>
메일 : ${expBean.userMail} <br>