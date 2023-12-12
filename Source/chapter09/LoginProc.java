package chapter09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		// 데이터베이스에어 추출한 실제 아이디와 패스워드라고 가정
		String realId = "kim";
		String realPw = "kimpass";
		
		// 사용자가 입력한 아이디와 패스워드 추출
		String userId = request.getParameter("userId");
		String userPw =  request.getParameter("userPw");
		
		// 아이디와 패스워드가 일치할 할 경우 처리
		if(userId.equals(realId) && userPw.equals(realPw) ) {
			
			// 세션을 생성
			HttpSession session = request.getSession();
			
			// HttpSessionBindingListener를 구현한 리스너 객체를 session의 속성으로 지정
			TestSessionListener login = new TestSessionListener(userId, userPw);
			session.setAttribute("login", login);
			
			// 변경된 접속자수를 반영하기 위해 5초에 한번씩 현재 문서를 reload. 
			out.println("<script type='text/javascript'>");
			out.println("setInterval('history.go(0)',5000)");
			out.println("</script>");
			
			// 로그인 정보와 로그아웃 하이퍼링크 출력
			out.println( login.getUserId() + "님. 로그인되었습니다<br>");
			out.println( "접속자 수 : " + TestSessionListener.persons + "<br>");
			out.println("<a href='logout'>로그아웃</a>");
		
		// 아이디와 패스워드가 일치하지 않을 경우 처리
		} else {
			response.sendRedirect("login.jsp");
		}
		
	}
}