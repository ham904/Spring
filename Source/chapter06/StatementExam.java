package chapter06;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/stmt")
public class StatementExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 객체 선언	
		Connection conn = null;
		Statement stmt = null;
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		try {
			
			// JDBC 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC";
			String jdbcId = "jspuser";
			String jdbcpw = "jsppass";
			conn = DriverManager.getConnection(url, jdbcId, jdbcpw);
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// 질의 생성과 실행
			String Query = "update student set grade=grade+1 where grade=0";
			int rows = stmt.executeUpdate(Query);
			out.println(rows + "개의 레코드가 변경되었습니다.");
						
			
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
