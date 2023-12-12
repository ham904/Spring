package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class UserLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	

		// 기존 세션을 얻어옴. 만약 존재하지 않으면 null을 반환
		HttpSession session = request.getSession(false);	
		
		// 세션이 존재할 경우
		if( (session != null) ) {
			
			// 사용자가 로그인을 했는지 조사하기 위한 loginState 세션 속성을 추출
			String loginCheck = (String) session.getAttribute("loginState");
			
			// 사용자가 정상적으로 로그인한 경우
			if( loginCheck != null) {
				
				// 세션 제거
				session.invalidate();
			
				out.println("<script>");
				out.println("alert('로그아웃되었습니다')");
				out.println("location.replace('LoginForm.jsp')");
				out.println("</script>");
				out.close();
			
			// 사용자가 로그인하지 않은 경우	
			} else {
				out.println("<script>");
				out.println("alert('로그인이 필요합니다.')");
				out.println("location.replace('LoginForm.jsp')");
				out.println("</script>");
				out.close();				
			}
		
		// 세션이 존재하지 않을 경우		
		} else {
			
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.')");
			out.println("location.replace('LoginForm.jsp')");
			out.println("</script>");
			out.close();			
		}
	}
		
}
