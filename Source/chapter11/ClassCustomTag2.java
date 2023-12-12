package chapter11;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ClassCustomTag2 extends SimpleTagSupport {
	
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
		
		for( int i=0; i<3; i++) {
			out.println(" " + UpperStr + " ");
		}
		
		out.println("<br>");
	}

}
