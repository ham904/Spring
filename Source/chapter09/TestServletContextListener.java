package chapter09;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestServletContextListener implements ServletContextListener {

    public TestServletContextListener() {
        System.out.println("TestServletContext 서블릿이 생성되었습니다.");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("TestServletContext 서블릿이 종료되었습니다.");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("TestServletContext 서블릿이 초기화되었습니다.");
    }
	
}

