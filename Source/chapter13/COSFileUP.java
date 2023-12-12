package chapter13;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/cos")
public class COSFileUP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		// 최종적으로 파일이 저장되는 위치의 경로를 추출
		ServletContext context = getServletContext();
		String realFolder = context.getRealPath("uploaded_files");
		
		// MultipartRequest 클래스의 인자
		int SizeLimit = 10*1024*1024;
		String EncType="utf-8";
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
				
		try {
		
			// MultipartRequest 객체 생성
			// MultipartRequest 객체가 생성되는 순간 파일 업로드 발생
			MultipartRequest multi = new MultipartRequest(request, realFolder, SizeLimit, EncType, policy);
			
			// 일반 텍스트 파라미터 출력
			Enumeration params = multi.getParameterNames();
			
			while( params.hasMoreElements() ) {
				String paramName = (String)params.nextElement();
				String paramValue = multi.getParameter(paramName);
				out.println( paramName + " : " + paramValue + "<br>");
			}
			out.println("<br><hr><br>");
			
			// file 입력양식 파라미터 추출
			Enumeration files = multi.getFileNames();
			
			while( files.hasMoreElements() ) {
				
				// 파라미터 이름 추출
				String userFileName = (String)files.nextElement();
				
				// 업로드된(파일이름 변경 전) 파일 이름 추출
				String originalFilename = multi.getOriginalFileName(userFileName);
				
				// 파일이 업로디된 경우 수행
				if( originalFilename != null ) {
					
					// 변경 전 파일이름 추출
					out.println("OriginalFilename : " + originalFilename + "<br>");
										
					// 같은 이름의 파일이 업로드된 경우 변경되어 저장된 파일 이름 출력
					String filesystemFilename = multi.getFilesystemName(userFileName);
					out.println("FilesystemFilename : " + filesystemFilename);
					
					// GET 방식으로 전달하는 파일 이름에 공백문가 있을 경우 처리 
					filesystemFilename = URLEncoder.encode(filesystemFilename,"utf-8");
					
					// down.do라는 서블릿으로 다운로드할 파일의 이름을 전달하는 하이퍼링크 생성
					out.println("<a href=down.do?filename="+filesystemFilename+">파일다운</a><br><br>");
					
					// 업로드된 파일의 File 객체 생성
					File userFile = multi.getFile(userFileName);
					
					// 파일의 크기 추출
					int fileSize = (int)userFile.length();
					
					// 파일의 크기와 타입 추출
					if( fileSize > 0) {
						out.println("크키 : " + fileSize + "<br>");
						out.println("종류 : " + multi.getContentType(userFileName) + "<br>");
					}
					out.println("<br><hr><br>");
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
