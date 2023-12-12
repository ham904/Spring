<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"  %>
<%@ page import="chapter08.*" %>

<%
	// <form>요소로부터 전달되는 파라미터가 있을 경우 인코딩 지정
	request.setCharacterEncoding("utf-8");
%>

<!-- StudentDAO 빈즈 클래스로부터 studentDAO 빈즈르 생성 -->
<jsp:useBean id="studentDAO" class="chapter08.StudentDAO"/>

<!-- StudentVO 빈즈 클래스로부터 studentVO 빈즈를 생성 -->
<jsp:useBean id="studentVO" class="chapter08.StudentVO" />

<!-- 전달된 파라미터들을 추출해 studentVO 빈즈에 저장-->
<jsp:setProperty property="*" name="studentVO"/>

<%
	// 파라미터로 전달되는 커맨트 코드 추출
	String action = request.getParameter("action");

	// 학생 정보 리스트 출력 ( 커맨드 코드 : list )
	if( action.equals("list")) {		
		ArrayList<StudentVO> stlist = studentDAO.getStudentList();
		request.setAttribute("studentList", stlist);
		pageContext.forward("studentList.jsp");		
	}
	
	// 학생 정보 입력 ( 커맨드 코드 : insert )
	if ( action.equals("insert") ) {
		
		if( studentDAO.insertStudent(studentVO )) {
			out.println("<script>");
			out.println("alert('학생 정보가 입력되었습니다.');");
			out.println("location.replace('studentController.jsp?action=list')");
			out.println("</script>");
			out.flush();
		}
		
	}
	
	// 변경할 학생 정보 추출 ( 커멘드 코드 : choose ) 
	if( action.equals("choose") ) {		
		String sID = request.getParameter("sID");		
		StudentVO student = studentDAO.getStudent(sID);
		request.setAttribute("student", student);
		pageContext.forward("studentModify.jsp");		
	}
	
	// 입력된 정보로 기존 정보를 변경 (커멘드 코드 : modify )
	if( action.equals("modify") ) {
		
		String sID = request.getParameter("sID");		
		if( studentDAO.modifyStudent(sID, studentVO) ) {
			response.sendRedirect("studentController.jsp?action=list");
		}
		
	}
	
	//학생 정보 삭제
	if( action.equals("delete") ) {

		String sID = request.getParameter("sID");		
		if( studentDAO.deleteStudent(sID) ) {
			out.println("<script>");
			out.println("alert('학생 정보가 삭제되었습니다.');");
			out.println("location.replace('studentController.jsp?action=list')");
			out.println("</script>");
			out.flush();;			
		}
	
	}
%>	