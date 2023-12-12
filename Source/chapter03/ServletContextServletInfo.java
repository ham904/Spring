package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scinfo")
public class ServletContextServletInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		ServletContext sc = getServletContext();				
				
		out.print("서블릿 버전 : " + sc.getMajorVersion() + "." + sc.getMinorVersion() +"<br>");		
		out.print("서버 정보 : " + sc.getServerInfo() + "<br>");
		out.print("애플리케이션 경로 : " + sc.getContextPath() + "<br>");
		out.print("애플리케이션 이름 : " + sc.getServletContextName() + "<br>");
		out.print("파일의 실제 경로 : " + sc.getRealPath("/"));
		
	}

}
