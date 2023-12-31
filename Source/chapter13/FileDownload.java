package chapter13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/down.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			// 전달된 파일의 이름을 추출
			String filename = request.getParameter("filename");

			// 저장될 위치의 절대 경로 추출
			ServletContext context = getServletContext();
			String realFolder = context.getRealPath("uploaded_files");

			// 저장될 위치와 파일 이름을 표현 
			String DirAndFilename = realFolder + "\\" + filename;
			
			// 업로르되는 파일의 File 객체 생성 
			File file = new File(DirAndFilename);		
			
			// 파일 이름에 한글이 포함되어 있을 경우 인코딩 지정
			filename = new String(filename.getBytes("utf-8"), "ISO-8859-1"); 
	       
			// 파일 다운로드를 위한 헤더 설정
			response.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\"");
			response.setContentLength((int)file.length());
			response.setHeader("Cache-control", "no-cache");
							
			// 파일 입력 스크림과 출력 스트림 생성
			FileInputStream in = new FileInputStream(file);
			OutputStream out = response.getOutputStream();

			// 버퍼 생성
			byte[] data = new byte[1024*1024];
			
			// 파일 출력 수행
			int count = -1;			
			while( (count = in.read(data)) != -1 ){
					out.write(data, 0, count);
			}
			
			in.close();
			out.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}		
		
	}

}
