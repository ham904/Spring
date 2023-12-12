package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetMaxAgeExam")
public class SetMaxAgeExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	

		// name 쿠키의 유효 시간을 1분으로 지정
		Cookie myCookie1 = new Cookie("name","gildong");
		myCookie1.setMaxAge(60);
		response.addCookie(myCookie1);
		
		// nation 쿠키의 유효 시간을 브라우저가 종료될때까지로 지정
		Cookie myCookie2 = new Cookie("nation","korea");
		myCookie2.setMaxAge(-1);
		response.addCookie(myCookie2);	
		
		out.println("name과 nation 쿠키가 생성되었습니다.");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
