package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		description = "파라미터지정", 
		urlPatterns = {"/scf1"}, 	 
		initParams = { 
				@WebInitParam(name = "username", value = "홍길동"), 
				@WebInitParam(name = "usercompany", value = "한국주식회사")
		})

public class ServletConfigInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = getInitParameter("username");
		String company = getInitParameter("usercompany");
		
		out.print(name + " : " + company);		
		
	}

}
