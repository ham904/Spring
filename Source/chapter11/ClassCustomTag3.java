package chapter11;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ClassCustomTag3 extends  SimpleTagSupport {

	// 반복횟수와 색상을 받아들이기 위한 프로퍼티 지정
	private int count;
	private String color;
	
	// count의 Setter와 Getter
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// color의 Setter와 Getter
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	// doTag() 재정의
	public void doTag() throws JspException, IOException {
		
		// JSP문서의 정보를 포함하는 JspContext 객체와 브라우저 출력을 위한 JspWriter 객체 생성
		JspContext context = this.getJspContext();
		JspWriter out = context.getOut();
		
		// 커스텀 태그 본체를 처리하기 위한  JspFragmant 객체 생성
		JspFragment body = this.getJspBody();
		
		// 커스텀 태그 본체의 문자열을 읽어 들여 출력 스트림에 출력
		StringWriter stringWriter = new StringWriter();
		body.invoke(stringWriter);
		
		// 출력 스트립의 내용을 문자열로 반환
		String str = stringWriter.toString();
		
		// 커스텀 태그 기능 구현
		String UpperStr = str.toUpperCase();
		
		// Getter를 이용해 반복회수와 색상 속성 값을 받아들임
		int iterCount = this.getCount();
		String color = this.getColor();
		
		// color 속성 지정 구문 구현 (색상 지정)
		out.println("<font color=\'" + color + "\'>");
		
		// count 속성 지정 구문 구현 (반복횟수 지정)
		for(int i=0; i < iterCount; i++) {
			out.println(" " + UpperStr + " ");
		}		
		
		out.println("</font><br>");
		
	}
}
