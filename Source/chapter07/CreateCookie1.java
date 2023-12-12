package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateCookie1")
public class CreateCookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		Cookie myCookie1 = new Cookie("id","hong");
		Cookie myCookie2 = new Cookie("name","홍길동");
		Cookie myCookie3 = new Cookie("age","25");

		response.addCookie(myCookie1);
		response.addCookie(myCookie2);
		response.addCookie(myCookie3);

		out.println("쿠키가 생성되었습니다");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
