package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModifyCookie")
public class ModifyCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	

		// 모든 쿠키를 추출하여 쿠키 배열로 반환 
		Cookie[] cookies = request.getCookies();
		
		// name 쿠키의 값을 변경
		if( (cookies!=null) && (cookies.length>0) ) {
			for( int i=0; i<cookies.length; i++ ) {
				if( cookies[i].getName().equals("name") ) {
					Cookie myCookie2 = new Cookie("name","이순신");
					response.addCookie(myCookie2);
					out.println("쿠키가 변경되었습니다");
					break;
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
