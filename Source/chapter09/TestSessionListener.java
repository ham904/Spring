package chapter09;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//@WebListener
public class TestSessionListener implements HttpSessionBindingListener {

	private String userId;
	private String userPw;
	static int persons = 0;
	
	//기본 생성자
    public TestSessionListener() {
    }

    //아이디와 패스워드를 인자로 가지는 생성자
    public TestSessionListener( String userId, String userPw ) {
    	this.userId = userId;
    	this.userPw = userPw;
    }
    
    //Getter 메서드 생성
    public String getUserId() {
		return userId;
	}

	public String getUserPw() {
		return userPw;
	}    
    
	//LoginListener의 객체가 session 속성으로 등록되었을 때 호출 
    public void valueBound(HttpSessionBindingEvent event)  { 
		++persons;
    }

  //session 속성으로 등록된 LoginListener의 객체가 헤제되었을 때 호출
    public void valueUnbound(HttpSessionBindingEvent event)  { 
		persons--;
	}
	
}
