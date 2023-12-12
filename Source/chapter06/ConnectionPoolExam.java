package chapter06;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

@WebServlet("/cp")
public class ConnectionPoolExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			// 객체 생성
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();	
			
			// DataSource 객체 생성
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
			
			// Connection 획득
			conn = ds.getConnection();
			
			// 질의 생성과 실행
			String Query = "select * from student";
			pstmt = conn.prepareStatement(Query);
			rs = pstmt.executeQuery();
			
			// ResultSet 객체의 레코드 추출과 출력
			while( rs.next() ) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String depart = rs.getString("depart");
				int grade = rs.getInt("grade");
				int score = rs.getInt("score");
				
				out.println(id+" / "+name+" / "+depart+" / "+grade+" / "+score);
				out.println("<br>");
				
			}			
			
			// 객체 종료
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch( NamingException | SQLException  e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
