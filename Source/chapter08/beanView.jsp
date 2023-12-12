<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="student" class="chapter08.StudentVO" scope="request" />

아이디 : <jsp:getProperty property="id" name="student"/> <br>
이름 : <jsp:getProperty property="name" name="student"/> <br>
학과 : <jsp:getProperty property="depart" name="student"/> <br>
등급 : <jsp:getProperty property="grade" name="student"/> <br>
점수 : <jsp:getProperty property="score" name="student"/> <br>