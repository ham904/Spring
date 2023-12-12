package chapter14;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class ExtPattern extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ExtDAO extDAO = new ExtDAO();

		String uri = request.getRequestURI();		
		String conPath = request.getContextPath();		
		String actCode = uri.substring(conPath.length());		
		
		if( actCode.equals("/list.do") ) {
			extDAO.list();
		}
		
		if( actCode.equals("/write.do") ) {
			extDAO.write();
		}		
		
	}
}
