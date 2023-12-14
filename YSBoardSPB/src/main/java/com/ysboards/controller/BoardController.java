package com.ysboards.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ysboards.service.BoardService;
import com.ysboards.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/YSBoardSPB")
public class BoardController {
	
	// BoardService boardService = new BoardService();
	private final BoardService boardService;
	BoardVO boardVO;
	
	@RequestMapping("/boardList.do")
	public String boardList(HttpServletRequest request) throws Exception {
		System.out.println("[boardList.do] 호출성공");
		List<BoardVO> recordList;
		
		//검색을 위한 파라미터 추출
		String col = request.getParameter("col");
		String key = request.getParameter("key");

		// 페이지 당 레코드 수, 페이지집합 당 레코드 수
		int pageRecords = 5;
		int pageSets = 5;
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
		
		request.setAttribute("col", col);
		request.setAttribute("key", key);		
		
		// 전체 레코드의 수를 추출해 request 영역의 속성으로 바인딩
		int totalRecord = boardService.recordCount(col, key);
		request.setAttribute("totalRecord",totalRecord);				
		
		// 전체 레코드 리스트를 추출개 request 영역의 속성으로 바인딩
		recordList = boardService.list(nowPage, pageRecords, col, key);
		
		if(recordList.isEmpty()) recordList = null; 				
		request.setAttribute("recordList", recordList);			
		

		// RequestDispatcher를 이용해 출력할 문서 지정
		//viewPage = "/boardList.jsp?col="+col+"&key="+key;
		return "boardList";
	}
	
	@RequestMapping("/boardListSearch.do")
	public String boardListSearch(HttpServletRequest request) throws Exception {
		System.out.println("[boardList.do] 호출성공");
		List<BoardVO> recordList;
		
		//검색을 위한 파라미터 추출
		String col = request.getParameter("col");
		String key = request.getParameter("key");

		// 페이지 당 레코드 수, 페이지집합 당 레코드 수
		int pageRecords = 5;
		int pageSets = 5;
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
		
		request.setAttribute("col", col);
		request.setAttribute("key", key);		
		
		// 전체 레코드의 수를 추출해 request 영역의 속성으로 바인딩
		int totalRecord = boardService.recordCount(col, key);
		request.setAttribute("totalRecord",totalRecord);				
		
		// 전체 레코드 리스트를 추출개 request 영역의 속성으로 바인딩
		recordList = boardService.list(nowPage, pageRecords, col, key);
		
		if(recordList.isEmpty()) recordList = null; 				
		request.setAttribute("recordList", recordList);	
		
		
//		if(recordList.size()<totalRecord) {
//			System.out.println("[BoardController] / boardListSearch.jsp 호출 ");
//			return "boardListSearch";
//		}
		// RequestDispatcher를 이용해 출력할 문서 지정
		//viewPage = "/boardList.jsp?col="+col+"&key="+key;
		return "boardListSearch";
	}
	
	@RequestMapping("/boardWriteForm.do")
	public String write(HttpServletRequest request) {
		String col = request.getParameter("col");
		String key = request.getParameter("key");
		
		request.setAttribute("col", col);
		request.setAttribute("key", key);
		// viewPage = "/boardWrite.jsp?col="+col+"&key="+key;
		return "boardWrite";	
	}
	
	@RequestMapping("/boardWrite.do")
	public ModelAndView insert(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");		
		BoardVO boardVO = new BoardVO();
		boardVO.setUserName(request.getParameter("userName"));
		boardVO.setUserMail(request.getParameter("userMail"));
		boardVO.setRcdSubject(request.getParameter("rcdSubject"));
		boardVO.setRcdContent(request.getParameter("rcdContent"));
		boardVO.setRcdPass(request.getParameter("rcdPass"));		
				
		boardService.insert(boardVO);
		
		// viewPage = "/boardList.do";
		// 개선사항: 이전 검색내용 유지
		ModelAndView mav = new ModelAndView("redirect:/boardList.do");
		return mav;
		
	}
	
	@RequestMapping("/boardContent.do")
	public String content(HttpServletRequest request) throws Exception {
		
		String col = request.getParameter("col");
		String key = request.getParameter("key");
		String nowPage = request.getParameter("nowPage");
		
		int rNo = Integer.parseInt(request.getParameter("rcdNO"));
		
		boardVO = boardService.content(rNo);
		request.setAttribute("record", boardVO);
		
		request.setAttribute("col", col);
		request.setAttribute("key", key);
		request.setAttribute("nowPage", nowPage);
						
		// viewPage = "/boardContent.jsp?rcdNO="+rNo+"&col="+col+"&key="+key+"&nowPage="+nowPage;
		return "boardContent";
	}
	
	@RequestMapping("/boardReplyForm.do")
	public String parentRecord(HttpServletRequest request) throws Exception {
		
		String col = request.getParameter("col");
		String key = request.getParameter("key");
		String nowPage = request.getParameter("nowPage");
		String rcdNO = request.getParameter("rcdNO");
		
		int rNo = Integer.parseInt(rcdNO);
		
		boardVO = boardService.parentRecord(rNo);						
		request.setAttribute("parent", boardVO);
		
		request.setAttribute("col", col);
		request.setAttribute("key", key);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("rNo", rcdNO);
		
		// viewPage = "/boardReply.jsp?rcdNO="+rNo+"&col="+col+"&key="+key+"&nowPage="+nowPage;
		
		return "boardReply";
	}
	
	@RequestMapping("/boardReply.do")
	public ModelAndView replyRecord(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");	
		BoardVO boardVO = new BoardVO();
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
		
//		request.setAttribute("col", col);
//		request.setAttribute("key", key);
//		request.setAttribute("nowPage", nowPage);
		
		String viewPage = "redirect:/boardList.do?col="+col+"&key="+key+"&nowPage="+nowPage;
		
		ModelAndView mav = new ModelAndView(viewPage);
		return mav;
	}
	
	@RequestMapping("/boardModifyForm.do")
	public String modifyForm(HttpServletRequest request) throws Exception {
		String col = request.getParameter("col");
		String key = request.getParameter("key");
		String nowPage = request.getParameter("nowPage");
		
		
		int rNo = Integer.parseInt(request.getParameter("rcdNO"));
		
		boardVO = boardService.modifyForm(rNo);
		request.setAttribute("record", boardVO);
		
		request.setAttribute("col", col);
		request.setAttribute("key", key);
		request.setAttribute("nowPage", nowPage);
		
		//viewPage = "/boardModify.jsp?rcdNO="+rNo+"&col="+col+"&key="+key+"&nowPage="+nowPage;
		return "boardModify";
	}
	
	@RequestMapping("/boardModify.do")
	public ModelAndView modify(HttpServletRequest request) throws Exception {
		String col = request.getParameter("col");
		String key = request.getParameter("key");
		String nowPage = request.getParameter("nowPage");
		
		int rNo = Integer.parseInt(request.getParameter("rcdNO"));
		String password = request.getParameter("rcdPass");
		
		boardVO.setUserMail(request.getParameter("userMail"));
		boardVO.setRcdSubject(request.getParameter("rcdSubject"));
		boardVO.setRcdContent(request.getParameter("rcdContent"));
		
		boardService.modify(rNo, password, boardVO);
		
		
//		request.setAttribute("col", col);
//		request.setAttribute("key", key);
//		request.setAttribute("nowPage", nowPage);
		String viewPage = "redirect:/boardContent.do?rcdNO="+rNo+"&col="+col+"&key="+key+"&nowPage="+nowPage;
		
		ModelAndView mav = new ModelAndView(viewPage);
		return mav;
	}
	
	@RequestMapping("/boardDeleteForm.do")
	public String deleteForm(HttpServletRequest request) throws Exception {
		String col = request.getParameter("col");
		String key = request.getParameter("key");
		String nowPage = request.getParameter("nowPage");
		
		int rNo = Integer.parseInt(request.getParameter("rcdNO"));
		
		boardVO = boardService.deleteForm(rNo);
		request.setAttribute("record", boardVO);
		
		request.setAttribute("col", col);
		request.setAttribute("key", key);
		request.setAttribute("nowPage", nowPage);
		
		//viewPage = "/boardDelete.jsp?rcdNO="+rNo+"&col="+col+"&key="+key+"&nowPage="+nowPage;
		return "boardDelete";
	}
	
	@RequestMapping("/boardDelete.do")
	public ModelAndView delete(HttpServletRequest request) throws Exception {
		System.out.println("[BoardController] / boardDelete.do 호출");
		String col = request.getParameter("col");
		String key = request.getParameter("key");
		String nowPage = request.getParameter("nowPage");
		
		int rNo = Integer.parseInt(request.getParameter("rcdNO"));
		String password = request.getParameter("rcdPass");		
	
		boardService.delete(rNo, password);		
		
		String viewPage = "redirect:/boardList.do?col="+col+"&key="+key+"&nowPage="+nowPage;
		
//		request.setAttribute("col", col);
//		request.setAttribute("key", key);
//		request.setAttribute("nowPage", nowPage);
		
		ModelAndView mav = new ModelAndView(viewPage);
		
		return mav;
	}
}
