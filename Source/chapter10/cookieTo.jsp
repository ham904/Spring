<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

userName : ${cookie.userName.value} <br>
userName : ${cookie.userName["value"]} <br>

user-pw : ${cookie["user-pw"].value }<br>
user-pw : ${cookie["user-pw"]["value"]}<br>

