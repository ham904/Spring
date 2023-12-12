package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// BoardDAO() : 생성자를 이용한 DataSource의 객체 생성 ---------------------------------------
	public BoardDAO() {
		try {			
			InitialContext context = new InitialContext();
			ds = (DataSource)context.lookup("java:/comp/env/jdbc/mysql");			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
}
