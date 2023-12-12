package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		// LoginForm.jsp 문서로 입력된 아이디와 패스워드 추출
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		// 데이터 객체의 생성과 파라키터 저장
		UserVO userVO = new UserVO();
		userVO.setId(userId);
		userVO.setPw(userPw);
		
		// UserDAO 객체 생성
		UserDAO userDAO = new UserDAO();		
		
		// 로그인 정보 존재 여부를 조사하는 userCheck() 메서드로 데이터 객체 전달		
		UserVO user = userDAO.userCheck(userVO);
		
		// 이름을 추출
		String userName = user.getName();
		
		// 아이디와 패스워드가 일치하는 경우(이름이 존재하는 경우)
		if (userName != null) {
			
			HttpSession session = request.getSession(true);
			
			session.setAttribute("loginId", userId);
			session.setAttribute("loginPw", userPw);			
			session.setAttribute("loginName", userName);			
			session.setAttribute("loginState","ok");
			
			out.println("<div>안녕하세요. " + userName + "님. 환영합니다.</div>");
			out.println("<hr width=300 align=left>");
			out.println("<a href='info'>사용자 정보 출력</a>");
		
		// 아이디와 패스워드가 일치하지 않는 경우(이름이 존재하지 않는 경우)
		} else {
			
			out.println("<div>아이디나 패스워드가 다릅니다</div>");
			out.println("<hr width=300 align=left>");
			out.println("<a href='LoginForm.jsp'>로그인</a>");			

		}		
	}
}