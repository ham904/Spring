package chapter11;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ClassCustomTag1 extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
	
		//  JSP문서의 정보를 포함하는 JspContext 객체 생성
		JspContext context = this.getJspContext();
		
		// 브라우저 출력을 위한 JspWriter 객체 생성
		JspWriter out = context.getOut();
		
		// 커스텀 태그 기능 구현
		out.println("==========");
		out.println("<br>");
		
	}
}

