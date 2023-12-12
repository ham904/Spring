package chapter12;

public class StudentBean {

	//프로퍼티 선언
	private String userName;
	private String userMail;
	
	public StudentBean(String userName, String userMail) {
		this.userName = userName;
		this.userMail = userMail;
	}
	
	// userName과 userMail의 Getter
	public String getUserName() {
		return userName;
	}
	
	// userMail 프로퍼티의 Getter와 Setter
	public String getUserMail() {
		return userMail;
	}
}
