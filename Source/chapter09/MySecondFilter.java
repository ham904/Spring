package chapter09;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter("/MySecondFilter")
public class MySecondFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("[MySecondFilter]------요청 필터 부분");
		chain.doFilter(request, response);
		System.out.println("[MySecondFilter]------응답 필터 부분");
	}
	
}
