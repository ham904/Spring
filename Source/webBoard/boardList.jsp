<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:set var="col" value="${param.col}" />
<c:set var="key" value="${param.key}" />

<%
	//페이지의 크기와 페이지 집합의 크기 추출
	int pageRecords = (int)request.getAttribute("pageRecords");
	int pageSets = (int)request.getAttribute("pageSets");

	// 현재 페이지 번호 추출
	int nowPage = (int)request.getAttribute("nowPage");

	// 모든 레코드 수 추출
	int totalRecord = (int)request.getAttribute("totalRecord");

	// 각 페이지의 시작 레코드 번호 추출
	int recordNO = totalRecord-(nowPage-1)*pageRecords; 

	// 전체 페이지의 수 추출
	int totalPages = (int)Math.ceil((double)totalRecord/pageRecords);
	
	// 전체 페이지 집합의 수 추출
	int totalPageSet = (int)Math.ceil((double)totalPages/pageSets);
	
	// 현재 페이지가 속한 페이지 집합의 번호 추출 
	int nowPageSet = (int)Math.ceil((double)nowPage/pageSets);

	// 페이지 링크 작성을 위한 현재 페이지 집합의 시작 페이지 번호 추출 
	int firstPage = pageSets*(nowPageSet-1);
	
	// 페이지 링크 작성을 위한 현재 페이지 집합의 마지막 페이지 번호 추출 
	int lastPage = pageSets*nowPageSet;
	if( totalPageSet == nowPageSet ) {
		lastPage = totalPages;
	}
	
%>

<c:set var="recordNO" value="<%=recordNO %>" />

<c:set var="totalPages" value="<%=totalPages %>" />
<c:set var="totalPageSet" value="<%=totalPageSet %>" />
<c:set var="nowPageSet" value="<%=nowPageSet %>" />

<c:set var="firstPage" value="<%=firstPage %>" />
<c:set var="lastPage" value="<%=lastPage %>" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 리스트 출력</title>
	<link rel="stylesheet" type="text/css" href="style.css">	
</head>
<body>

	<table class="noline">
		<tr><td class=header>게시글 리스트 출력</td><tr>
	</table>	
	<hr align=center width=680 size=3 noshade>

	<table class="main">
		
		<tr align=center>
			<td class=title1 width=30>번호</td>
			<td class=title1 width=400>글제목</td>
			<td class=title1 width=60>작성자</td>
			<td class=title1 width=90>작성일</td>
			<td class=title1 width=40>조회수</td>
		</tr>
		
	<c:choose>
	
		<c:when test="${recordList==null}">		
			<tr align=center>
				<td colspan=5> 등록된 글이 없습니다 </td>
			</tr>
		</c:when>
				
		<c:otherwise>
			<c:forEach var="record" items="${recordList}" >
				<tr>
					<td class=content1> ${recordNO} </td>
					<td class=content1-left>
						<c:forEach begin="1" end="${record.rcdIndent}">
								&nbsp;
						</c:forEach>					
						<a href="${contextPath}/boardContent.do?rcdNO=${record.rcdNO}&col=${col}&key=${key}&nowPage=${nowPage}">
							${record.rcdSubject}
						</a>						
					 </td>
					<td class=content1> ${record.userName} </td>
					<td class=content1> ${record.rcdDate} </td>
					<td class=content1> ${record.rcdRefer} </td>						
				</tr>
				<c:set var="recordNO" value="${recordNO-1}" />
			</c:forEach>
		</c:otherwise>
		
	</c:choose>
				
	</table>
	
	<form name="search" method="post" action="${contextPath}/boardList.do">
	<table align=center>
		<tr>
		
			<td align=left width=50>
				<input type="button" value="WRITE" onClick="location.replace('${contextPath}/boardWriteForm.do?col=${col}&key=${key}&nowPage=${nowPage}')">
			</td>
			
			<td class="links" width="390">
			
			<c:if test="${recordList != null}"> 
				<c:choose>
					<c:when test="${nowPageSet>1}">
						<c:set var="beforeSetPage" value="${pageSets*(nowPageSet-1)}"/>
						<a href="${contextPath}/boardList.do?nowPage=${beforeSetPage}&col=${col}&key=${key}">
							[PreSet]
						</a>
					</c:when>
					<c:otherwise>
						[PreSet]
					</c:otherwise>				
				</c:choose>
				
				<c:choose>
					<c:when test="${nowPage>1}">
						<c:set var="beforePage" value="${nowPage-1}"/>
						<a href="${contextPath}/boardList.do?nowPage=${beforePage}&col=${col}&key=${key}">
							[Pre]
						</a>
					</c:when>
					<c:otherwise>
						[Pre]
					</c:otherwise>	
				</c:choose>
				
				<c:forEach begin="${firstPage+1}" end="${lastPage}" >
					<a href="${contextPath}/boardList.do?nowPage=${firstPage+1}&col=${col}&key=${key}">
						${firstPage+1}
					</a>
					<c:set var="firstPage" value="${firstPage+1}" />					
				</c:forEach>		

				<c:choose>
					<c:when test="${totalPages > nowPage}">
						<c:set var="nextPage" value="${nowPage+1}"/>
						<a href="${contextPath}/boardList.do?nowPage=${nextPage}&col=${col}&key=${key}">
							[Next]
						</a>
					</c:when>
					<c:otherwise>
						[Next]
					</c:otherwise>	
				</c:choose>

				<c:choose>
					<c:when test="${ totalPageSet > nowPageSet }">
						<c:set var="nextSetPage" value="${pageSets*nowPageSet+1}"/>
						<a href="${contextPath}/boardList.do?nowPage=${nextSetPage}&col=${col}&key=${key}">
							[NextSet]
						</a>
					</c:when>
					<c:otherwise>
						[NextSet]
					</c:otherwise>	
				</c:choose>
				</c:if>	
							
			</td>
			
			<td align=right width=220>
				<select name="col">
					<option value="rcdSubject">제목</option>
					<option value="rcdContent">내용</option>					
				</select>
				<input type="text" name="key" size=10>
				<input type="submit" value="검색">
			</td>
			
		</tr>		
	</table>
	</form>
			
</body>
</html>