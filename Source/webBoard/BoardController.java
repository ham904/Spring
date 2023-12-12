package webBoard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BoardService boardService;
	BoardVO boardVO;

	// init() : init 메서드를 이용한 boardService와 boardVO 객체 생성 ------------
	public void init() throws ServletException {
		boardService = new BoardService();
		boardVO = new BoardVO();		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Handle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Handle(request, response);
	}
	
	protected void Handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String viewPage = "";
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 전달된 URL로부터 요청 정보 추출 -------------------------------------------------------------
		String uri = request.getRequestURI();		
		String conPath = request.getContextPath();		
		String actCode = uri.substring(conPath.length());		

		try {
			
			// 전체 레코드의 수와 전체 레코드 리스트를 boardList.jsp에 전달해 출력------------------------------
			if( actCode.equals("/boardList.do") ) {
			
				List<BoardVO> recordList = new ArrayList<BoardVO>();
				
				//검색을 위한 파라미터 추출
				String col = request.getParameter("col");
				String key = request.getParameter("key");

				// 페이지 당 레코드 수, 페이지집합 당 레코드 수
				int pageRecords = 10;
				int pageSets = 10;
				request.setAttribute("pageRecords", pageRecords);
				request.setAttribute("pageSets", pageSets);				
				
				//현재 페이지 지정
				int nowPage=0;
				if( request.getParameter("nowPage") == null) {
					nowPage = 1;
				} else {
					nowPage = Integer.parseInt(request.getParameter("nowPage"));
				}				
				request.setAttribute("nowPage", nowPage);							
				
				// boardService의 recordCount()를 호출해 전체 레코드의 수를 추출
				int totalRecord = boardService.recordCount(col, key);
				request.setAttribute("totalRecord",totalRecord);				
				
				// boardService의 list()를 호출해 전체 레코드 리스트를 추출
				recordList = boardService.list(nowPage, pageRecords, col, key);
				
				if(recordList.isEmpty()) recordList = null; 				
				request.setAttribute("recordList", recordList);	
				
				// RequestDispatcher를 이용해 출할 문서 지정
				viewPage = "/boardList.jsp";				
				
			}
			
			// 레코드 입력 양식 문서 출력 -------------------------------------------------------------
			if( actCode.equals("/boardWriteForm.do") ) {
				
				String col = request.getParameter("col");
				String key = request.getParameter("key");
				
				viewPage = "/boardWrite.jsp?col="+col+"&key="+key;				
			}			

			// 레코드 입력 ---------------------------------------------------------------------
			if( actCode.equals("/boardWrite.do") ) {

				boardVO.setUserName(request.getParameter("userName"));
				boardVO.setUserMail(request.getParameter("userMail"));
				boardVO.setRcdSubject(request.getParameter("rcdSubject"));
				boardVO.setRcdContent(request.getParameter("rcdContent"));
				boardVO.setRcdPass(request.getParameter("rcdPass"));
						
				boardService.insert(boardVO);
				
				viewPage = "/boardList.do";

			}			
			
			// 레코드 내용 출력 --------------------------------------------
			if( actCode.equals("/boardContent.do") ) {
				
				String col = request.getParameter("col");
				String key = request.getParameter("key");
				String nowPage = request.getParameter("nowPage");

				int rNo = Integer.parseInt(request.getParameter("rcdNO"));
				
				boardVO = boardService.content(rNo);
				request.setAttribute("record", boardVO);
								
				viewPage = "/boardContent.jsp?rcdNO="+rNo+"&col="+col+"&key="+key+"&nowPage="+nowPage;		
			}

			// 답변 레코드 양식 문서 출력 --------------------------------------------
			if( actCode.equals("/boardReplyForm.do") ) {
				
				String col = request.getParameter("col");
				String key = request.getParameter("key");
				String nowPage = request.getParameter("nowPage");
				
				int rNo = Integer.parseInt(request.getParameter("rcdNO"));
				
				boardVO = boardService.parentReccord(rNo);						
				request.setAttribute("parent", boardVO);
				
				viewPage = "/boardReply.jsp?rcdNO="+rNo+"&col="+col+"&key="+key+"&nowPage="+nowPage;	
			}
			
			// 답변 레코드 입력 -------------------------------------------------
			if( actCode.equals("/boardReply.do") ) {
				
				String col = request.getParameter("col");
				String key = request.getParameter("key");
				String nowPage = request.getParameter("nowPage");

				int rNo = Integer.parseInt(request.getParameter("rcdNO"));

				boardVO.setUserName(request.getParameter("userName"));
				boardVO.setUserMail(request.getParameter("userMail"));
				boardVO.setRcdSubject(request.getParameter("rcdSubject"));
				boardVO.setRcdContent(request.getParameter("rcdContent"));
				boardVO.setRcdPass(request.getParameter("rcdPass"));
			
				boardService.replyRecord(boardVO, rNo);
				
				viewPage = "/boardList.do?col="+col+"&key="+key+"&nowPage="+nowPage;
			}

			// 레코드 수정 양식 출력 --------------------------------------------
			if( actCode.equals("/boardModifyForm.do") ) {
				
				String col = request.getParameter("col");
				String key = request.getParameter("key");
				String nowPage = request.getParameter("nowPage");	
				
				int rNo = Integer.parseInt(request.getParameter("rcdNO"));
				
				boardVO = boardService.modifyForm(rNo);
				request.setAttribute("record", boardVO);
				
				viewPage = "/boardModify.jsp?rcdNO="+rNo+"&col="+col+"&key="+key+"&nowPage="+nowPage;
			}
			
			// 레코드 수정 -----------------------------------------------------
			if( actCode.equals("/boardModify.do") ) {
				
				String col = request.getParameter("col");
				String key = request.getParameter("key");
				String nowPage = request.getParameter("nowPage");
				
				int rNo = Integer.parseInt(request.getParameter("rcdNO"));
				String password = request.getParameter("rcdPass");
				
				boardVO.setUserMail(request.getParameter("userMail"));
				boardVO.setRcdSubject(request.getParameter("rcdSubject"));
				boardVO.setRcdContent(request.getParameter("rcdContent"));
				
				boardService.modify(rNo, password, boardVO);
				
				viewPage = "/boardContent.do?rcdNO="+rNo+"&col="+col+"&key="+key+"&nowPage="+nowPage;
					
			}			
	
			// 레코드 삭제 양식 출력 -----------------------------------------------------
			if( actCode.equals("/boardDeleteForm.do") ) {
				
				String col = request.getParameter("col");
				String key = request.getParameter("key");
				String nowPage = request.getParameter("nowPage");
				
				int rNo = Integer.parseInt(request.getParameter("rcdNO"));
				
				boardVO = boardService.deleteForm(rNo);
				request.setAttribute("record", boardVO);
				
				viewPage = "/boardDelete.jsp?rcdNO="+rNo+"&col="+col+"&key="+key+"&nowPage="+nowPage;				
				
			}
			
			// 레코드 삭제 -----------------------------------------------------
			if( actCode.equals("/boardDelete.do") ) {
				
				String col = request.getParameter("col");
				String key = request.getParameter("key");
				String nowPage = request.getParameter("nowPage");
				
				int rNo = Integer.parseInt(request.getParameter("rcdNO"));
				String password = request.getParameter("rcdPass");

				boardService.delete(rNo, password);
				
				viewPage = "/boardList.do?col="+col+"&key="+key+"&nowPage="+nowPage;

			}					
			
			// viewPage가 지정한 페이지로 분기 ------------------------------------------------------
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);			
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
	}

}