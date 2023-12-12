package chapter07;

public class UserVO {

	//아이디, 패스워드, 이름을 저장하기 위한 멤버변수 선언
	private String id;
	private String pw;
	private String name;
	
	// id 멤버변수의 Getter와 Setter	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// pw 멤버변수의 Getter와 Setter	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	// name 멤버변수의 Getter와 Setter	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}