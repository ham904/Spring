package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SetInterval")
public class SetInterval extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		//세션 객체 생성
		HttpSession session = request.getSession();

		//유효 시간과 세션 속성 지정
		session.setMaxInactiveInterval(20);
		session.setAttribute("name", "이순신");
		session.setAttribute("nation", "대한민국");
		
		out.println("name과 nation 세션 속성이 추가되었습니다.<br>");
		
		//세션 속성 출력을 위한 링크 생성
		out.println("<a href='setIntervalShow.jsp'>세션속성 출력</a>");
		
	}	

}
