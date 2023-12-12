<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%
	try {
		
		String filename = request.getParameter("filename");
		
		ServletContext context = getServletContext();
		String realFolder = context.getRealPath("uploaded_files");

		String DirAndFilename = realFolder + "\\" + filename;
		File file = new File(DirAndFilename);
		
		//out.clear();
		//pageContext.pushBody();
		
		filename = new String(filename.getBytes("utf-8"), "ISO-8859-1"); 
		
				
		response.setContentType("application/octer-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setContentLength((int)file.length());
		response.setHeader("Cache-control", "no-cache");
		
		byte[] data = new byte[1024*1024];
		
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream fos = new BufferedOutputStream(response.getOutputStream());
		
		int count=0;
		while( (count = fis.read(data)) != -1 ){
			fos.write(data);
		}		
		
	} catch(IOException e) {
		e.printStackTrace();
	}


%>