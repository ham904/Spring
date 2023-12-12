package chapter04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gParam2")
public class GetParameterNames extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Enumeration<String> param = request.getParameterNames();
		
		while(param.hasMoreElements()) {
			String pName = param.nextElement();
			String pValue = request.getParameter(pName);
			out.print(pName + " : " + pValue + "<br>");
		}
	}

}
