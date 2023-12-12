package chapter09;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(filterName="filter2")
public class AnnoFilter2 implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("[AnnoFilter2] --- 요청 필터 부분 ");
		chain.doFilter(request, response);
		System.out.println("[AnnoFilter2] --- 응답 필터 부분 ");
	}

}
