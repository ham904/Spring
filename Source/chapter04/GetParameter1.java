package chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gParam1")
public class GetParameter1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//POST 방식으로 전달되는 데이터 임코딩 지정
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 파라미터 추출
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		float score = Float.parseFloat(request.getParameter("score"));
		
		out.print("번호 : " + num + "<br>");
		out.print("이름 : " + name + "<br>");
		out.print("성적 : " + score + "<br>");		
		
	}
}
