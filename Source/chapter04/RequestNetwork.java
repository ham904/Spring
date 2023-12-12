package chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reqNet")
public class RequestNetwork extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("프로토콜 : " + request.getScheme() + "<br>");
		out.print("프로토콜과버전 : " + request.getProtocol() + "<br>");		
		out.print("클라이언트IP : " + request.getRemoteAddr() + "<br>");
		out.print("서버의IP : " + request.getLocalAddr() + "<br>");
		out.print("서버의이름 : " + request.getServerName() + "<br>");
		out.print("서버의port : " + request.getServerPort() + "<br>");
		out.print("요청방식 : " + request.getMethod() + "<br>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
