package chapter14;

import java.util.Date;

public class BoardVO {

	private int rcdNO;
	private int rcdGrpNO;
	private String userName;
	private String userMail;
	private String rcdSubject;
	private String rcdContent;
	private String rcdPass;
	private Date rcdDate;
	private int rcdRefer;
	private int rcdIndent;
	private int rcdOrder;
	
	// rcdNO 변수의 Getter와 Setter
	public int getRcdNO() {
		return rcdNO;
	}
	public void setRcdNO(int rcdNO) {
		this.rcdNO = rcdNO;
	}
	
	// rcdGrpNO 변수의 Getter와 Setter	
	public int getRcdGrpNO() {
		return rcdGrpNO;
	}
	public void setRcdGrpNO(int rcdGrpNO) {
		this.rcdGrpNO = rcdGrpNO;
	}
	
	// userName 변수의 Getter와 Setter
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	// userMail 변수의 Getter와 Setter
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	
	// rcdSubject 변수의 Getter와 Setter
	public String getRcdSubject() {
		return rcdSubject;
	}
	public void setRcdSubject(String rcdSubject) {
		this.rcdSubject = rcdSubject;
	}
	
	// rcdContent 변수의 Getter와 Setter
	public String getRcdContent() {
		return rcdContent;
	}	
	public void setRcdContent(String rcdContent) {
		this.rcdContent = rcdContent;
	}
	
	// rcdPass 변수의 Getter와 Setter
	public String getRcdPass() {
		return rcdPass;
	}
	public void setRcdPass(String rcdPass) {
		this.rcdPass = rcdPass;
	}
	
	// rcdDate 변수의 Getter와 Setter
	public Date getRcdDate() {
		return rcdDate;
	}
	public void setRcdDate(Date rcdDate) {
		this.rcdDate = rcdDate;
	}
	
	// rcdRefer 변수의 Getter와 Setter
	public int getRcdRefer() {
		return rcdRefer;
	}
	public void setRcdRefer(int rcdRefer) {
		this.rcdRefer = rcdRefer;
	}
	
	// rcdIndent 변수의 Getter와 Setter
	public int getRcdIndent() {
		return rcdIndent;
	}
	public void setRcdIndent(int rcdIndent) {
		this.rcdIndent = rcdIndent;
	}
	
	// rcdOrder 변수의 Getter와 Setter
	public int getRcdOrder() {
		return rcdOrder;
	}
	public void setRcdOrder(int rcdOrder) {
		this.rcdOrder = rcdOrder;
	}	
	
}
