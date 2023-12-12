package chapter07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {

	// 객체 선언 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;	
	
	// 생성자를 이용한 DataSource 객체 생성
	public UserDAO() {		
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 아이디와 패스워드가 일치하는 레코드가 존재하는지 조사 
	// 존재하는 경우, 해당 레코드의 userName 필드 값을 userVO 객체에 저장해 전달
	public UserVO userCheck(UserVO userVO) {
		
		try {
			String id = userVO.getId();
			String pw = userVO.getPw();

			conn = ds.getConnection();
			String query = "select * from userInfo where userId=? and userPw=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				userVO.setName(rs.getString("userName"));	
			}			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userVO;		
		
	}	
	
}