package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessInvalidate")
public class SessInvalidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		//기존 세션을 얻어옴 
		HttpSession session = request.getSession();

		//세션을 제거
		session.invalidate();
		
		//세션 속성 출력을 위한 링크
		out.println("<a href='setIntervalShow.jsp'>세션속성 출력</a>");
	}

}
