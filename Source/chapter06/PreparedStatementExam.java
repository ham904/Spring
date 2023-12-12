package chapter06;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pstmt")
public class PreparedStatementExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 객체 선언	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		try {

			// JDBC 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC";
			String jdbcId = "jspuser";
			String jdbcpw = "jsppass";
			conn = DriverManager.getConnection(url, jdbcId, jdbcpw);
			
			//PreparedStatement 객체 생성
			String Query = "insert into student values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(Query);
			
			//위치홀더 지정
			pstmt.setString(1, "shlee");
			pstmt.setString(2, "이순신");
			pstmt.setString(3, "정보통신공학과");
			pstmt.setInt(4, 1);
			pstmt.setInt(5, 850);
			
			//질의 실행
			pstmt.executeUpdate();			
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
