package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionAttrShow")
public class SessionAttrShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		//기존 세션을 얻어옴 
		HttpSession session = request.getSession();
		
		// 세션 속성 추출
		out.println("id : " + session.getAttribute("id") + "<br>");
		out.println("name : " + session.getAttribute("name") + "<br>");
		
	}

}
