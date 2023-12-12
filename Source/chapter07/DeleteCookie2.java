package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCookie2")
public class DeleteCookie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	

		// 모든 쿠키를 추출하여 쿠키 배열로 반환 
		Cookie[] cookies = request.getCookies();
		
		// 쿠키 배열의 모든 쿠키를 제거
		if( (cookies!=null) && (cookies.length>0) ) {
			for( int i=0; i<cookies.length; i++ ) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
			out.println("모든 쿠키가 제거되었습니다.");
		} else {
			out.println("쿠키가 존재하지 않습니다.");
		}
	}

}
