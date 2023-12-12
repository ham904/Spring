package chapter13;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/commons")
public class CommonsFileUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		// 최종적으로 파일이 저장되는 위치의 경로를 추출
		ServletContext context = getServletContext();
		String realFolder = context.getRealPath("uploaded_files");
		
		// DiskFileItemFactory 객체 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 업로드되는 파일의 크기를 1MBytes로 지전
		factory.setSizeThreshold(1024*1024);
		
		// 업로드된 파일의 크기가 1MB를 초과할 경우 최종적으로 파일이 저장되는 곳을 임시 저장소로 지정 
		File currentDirAndPah = new File(realFolder);
		factory.setRepository(currentDirAndPah);
		
		// ServletFileUpload 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			
			// multipart/form-data 형식으로 전달된 모든 데이터를 List에 저장
			List<FileItem> items = upload.parseRequest(request);
			
			for( int i=0; i<items.size(); i++ ) {
				
				// 리스트로 부터 순차적으로 데이터를 주줕
				FileItem fileItem = (FileItem)items.get(i);				
				
				if( fileItem.isFormField() ) {
					
					// 추출한 데이터가 일반 택스트인 경우 파라미터의 이름과 값을 출력
					out.println(fileItem.getFieldName() +":" + fileItem.getString("utf-8") +"<br><br>");
					
				} else {
					
					// 추출한 데이터가 파일인 경우
					if( fileItem.getSize() > 0 ) {
						
						// 파일의 이름을 추출해 출력
						String fileName = (String)fileItem.getName();
						out.println("filemame : <br> " + fileName + "<br><br>");
						
						// 파일의 최정 저장 위치와 피일의 이름을 출력
						String DirAndFilename = realFolder + "\\" + fileName;
						out.println("Directory+Filename : <br> " + DirAndFilename + "<br><br>");
						
						//파일을 최정 위치인 uploaded_files에 저장 
						File uploadFile = new File(DirAndFilename);
						
						// ㅈ붕복된 팡리이 있는 경우 처리
						if( uploadFile.exists() ) {
							
							// 파일의 이름과 확장자를 분리 (fname:파일이름, fext:확장자)
							int pos = fileName.lastIndexOf(".");
							String fname = fileName.substring(0, pos);
							String fext = fileName.substring(pos+1);
							
							// 중복된 이름이 존재하지 않을 떄까지 순환
							for( int j=1; true; j++ ) {	
								
								// 파일의 이름을 파일명(숫자).확장자 형식으로 변경
								fileName = fname + "(" + j + ")."+ fext;							
								
								DirAndFilename = realFolder + "\\" + fileName;
								uploadFile = new File(DirAndFilename);
								
								// 중복된 파일이 있는지 다시 조사(더이상 없을 경우 파일의 최종이름으로 지정)
								if( !uploadFile.exists() ) {
									break;
								}
							}
														
						} 
						fileItem.write(uploadFile);
						
						// 파일의 크기를 출력
						out.println("size : <br>" + fileItem.getSize() + "bytes <br><hr>");
					}
					
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}		

	}

}