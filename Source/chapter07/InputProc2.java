package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InputProc2")
public class InputProc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	

		String name = request.getParameter("name");
		String depart = request.getParameter("depart");
		
		out.println("이름 : " + name + "<br>");
		out.println("부서 : " + depart);	}

}
