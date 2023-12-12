package chapter08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import chapter08.StudentVO;

public class StudentDAO {

	// 객체 선언
	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 생성자를 이용한 DataSource 객체 생성
	public StudentDAO() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	// 학생정보 리스트를 출력하기 위한 getStudentList() 메서드
	public ArrayList<StudentVO> getStudentList() {
		
		// 학생 정보 리스트를 반환할 ArrayList를 생성
		ArrayList<StudentVO> stlist = new ArrayList<StudentVO>();
		
		try {
			
			conn = ds.getConnection();
			
			// 모든 학생 정보를 추출하는 질의 실행
			String Query = "select * from student order by name ASC";
			pstmt = conn.prepareStatement(Query);
			rs = pstmt.executeQuery();
			
			//모든 학생 정보를 추출하여 stlists라는 ArrayList에 저장  
			while( rs.next() ) {
				
				StudentVO student = new StudentVO();
				
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setDepart(rs.getString("depart"));
				student.setGrade(rs.getInt("grade"));
				student.setScore(rs.getInt("score"));
				
				stlist.add(student);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// stlists를 반환
		return stlist;
	}	
	
	// 학생 정보를 입력하기 위한 insertStudent() 메서드
	public Boolean insertStudent( StudentVO studentVO ) {
		
		try {
			
			conn = ds.getConnection();
			
			String Query = "insert into student values (?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, studentVO.getId());
			pstmt.setString(2, studentVO.getName());
			pstmt.setString(3, studentVO.getDepart());
			pstmt.setInt(4, studentVO.getGrade());
			pstmt.setInt(5, studentVO.getScore());
			pstmt.executeUpdate();

		} catch( Exception e ) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	// 수정할 학생 정보를 추출하기 위한 setStudent() 메서드
	public StudentVO getStudent(String sID) {
		
		StudentVO student = new StudentVO();
		
		try {
			
			conn =ds.getConnection();
			
			String Query = "select * from student where id=?";
			
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, sID);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			student.setId(rs.getString("id"));
			student.setName(rs.getString("name"));
			student.setDepart(rs.getString("depart"));
			student.setGrade(rs.getInt("grade"));
			student.setScore(rs.getInt("score"));
						
		} catch ( Exception e ) {
			e.printStackTrace();			
		}
		
		return student;
	}
	
	// 학생 정보 수정
	public Boolean modifyStudent(String sID, StudentVO studentVO) {
		
		try {
			
			conn = ds.getConnection();
			
			String Query = "update student set depart=?, grade=?, score=? where id=?";
			
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, studentVO.getDepart());
			pstmt.setInt(2, studentVO.getGrade());
			pstmt.setInt(3, studentVO.getScore());
			pstmt.setString(4, sID);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	// 학생 정보 레코드 삭제
	public Boolean deleteStudent(String sID) {
		
		try {
			
			conn = ds.getConnection();
			
			String Query="delete from student where id=?";
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, sID);
			pstmt.executeUpdate();
			
		} catch ( Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
}
