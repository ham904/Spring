package chapter09;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestServletRequestListener implements ServletRequestListener, ServletRequestAttributeListener {

    public TestServletRequestListener() {
        System.out.println("TestServletRequest 객체가 생성되었습니다.");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
        System.out.println("TestServletRequest 객체가 초기화되었습니다.");
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
        System.out.println("TestServletRequest 객체의 속성이 추가되었습니다.");
    }

}
