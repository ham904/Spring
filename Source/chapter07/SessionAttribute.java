package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionAttribute")
public class SessionAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		//세션 객체 생성
		HttpSession session = request.getSession();

		// 세션 속성 지정
		session.setAttribute("id", "hong");
		session.setAttribute("name", "홍길동");
	
		// 링크 생성
		out.println("<a href='SessionAttrShow'>세션속성 출력1</a>");
		out.println("<br>");
		out.println("<a href='AttrShow.jsp'>세션속성 출력2</a>");
		
	}

}
