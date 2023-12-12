package chapter09;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
		urlPatterns ="/*",
		initParams = @WebInitParam(name="Encode", value="UTF-8")
		)
public class EncodeFilter2 implements Filter {

	String charEnc;
	
	public void init(FilterConfig config) {
		charEnc = config.getInitParameter("Encode");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charEnc);
		chain.doFilter(request, response);
	}

}
