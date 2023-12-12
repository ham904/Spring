package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionInfo")
public class SessionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		//세션 객체 생성
		HttpSession session = request.getSession();
		
		// 세션의 생성 여부 조사
		if( session.isNew() ) {
			out.println("새로운 세션이 생성되었습니다.<br><br>");
		} else {
			out.println("이미 생성되어 있는 세션입니다.<br><br>");			
		}
		
		// 세션 정보 출력
		out.println("세션 ID : " + session.getId() + "<br><br>");
		out.println("세션 생성 시각 : " + session.getCreationTime() + "<br>");
		out.println("최근 접근 시각 : " + session.getLastAccessedTime());
		
	}

}