package chapter14;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class DirPattern extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DirDAO dirDAO = new DirDAO();
		String actCode = request.getPathInfo();
		
		if( actCode.equals("/list.do") ) {
			dirDAO.list();
		}
		
		if( actCode.equals("/write.do") ) {
			dirDAO.write();
		}		
		
	}
}
