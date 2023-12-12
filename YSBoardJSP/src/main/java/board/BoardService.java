package board;

import java.util.List;

import board.BoardDAO;
import board.BoardVO;

public class BoardService {

	BoardDAO boardDAO;
	
	// BoardService() : 생성자를 이용한 BoardDAO의 객체 생성 --------------------------------------------
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	// recordCount() : boardDAO의 totalRecord()를 호출해 전체 레코드 수 추출 -----------------------------
	public int recordCount(String col, String key) {
		int totalRecord = boardDAO.totalRecord(col, key);
		return totalRecord;
	}
	
	// boardList() : boardDAO의 selectAllRecords()를 호출해 모든 레코드 리스트 추출 ------------------------
	public List<BoardVO> list(int nowPage, int pageRecords, String col, String key) {
		List<BoardVO> recordList = boardDAO.selectAllRecords(nowPage, pageRecords, col, key);
		return recordList;		
	}
	
	// content() :boardDAO의 incrementRcdRefer()와 selectRecord()를 호출 ---------------------------
	public void insert(BoardVO boardVO) {
		
		int newNO = boardDAO.newRcdNO();
		
		boardVO.setRcdNO(newNO);
		boardVO.setRcdGrpNO(newNO);
		boardVO.setRcdRefer(0);
		boardVO.setRcdIndent(0);
		boardVO.setRcdOrder(1);
		
		boardDAO.insertRecord(boardVO);
	}
	
	// content() :boardDAO의 incrementRcdRefer()와 selectRecord()를 호출 -------------------
	public BoardVO content(int rNo)
	{
		boardDAO.incrementRcdRefer(rNo);;
		BoardVO record = boardDAO.selectRecord(rNo);
		return record;		
	}

	// parentRecord() : 답변글 작성 문서 상단에 부모 레코드 제목과 내용 출력 --------------------------
	public BoardVO parentRecord(int rNo) {
		BoardVO parent = boardDAO.selectParentRecord(rNo);
		return parent;
	}
	
	// replyRecord() : 답변글 입력 -----------------------------------------------------------------------------
	public void replyRecord(BoardVO boardVO, int rNo ) {
		
		int newNO = boardDAO.newRcdNO();
		
		BoardVO replyInfo = boardDAO.getParentField(rNo);
		int rGrpNo = replyInfo.getRcdGrpNO();
		int rIndent = replyInfo.getRcdIndent();
		int nOrder = replyInfo.getRcdOrder();
		
		int newRcdIndent = rIndent+1;
		int newRcdOrder = nOrder+1;
		
		boardDAO.incrRcdOrder(rGrpNo, nOrder);
		
		boardVO.setRcdNO(newNO);
		boardVO.setRcdGrpNO(rGrpNo);
		boardVO.setRcdRefer(0);
		boardVO.setRcdIndent(newRcdIndent);
		boardVO.setRcdOrder(newRcdOrder);
		
		boardDAO.insertRecord(boardVO);
		
	}

	// modifyRecordForm() : 수정할 레코드의 내용 추출  ---------------------------------------------------
	public BoardVO modifyForm(int rNo) {
		
		BoardVO record = boardDAO.selectRecord(rNo);
		return record;
	}
	
	// modify() : 패스워드가 일치하는지 조사하고 일치할 경우 레코드를 수정 --------------------------
	 public void modify(int rNo, String password, BoardVO boardVO) {
		 if( boardDAO.checkPassword(rNo, password) ) {
			 boardDAO.modifyRecord(rNo, boardVO);
		 }
	 } 
	 
	 // deleteForm() : 삭제할 레코드를 출력하고 패스워드를 입력 받음 ----------------------------------- 
	 public BoardVO deleteForm(int rNo) {
		BoardVO record = boardDAO.selectRecord(rNo);
		return record;		 
	 }
	 
	// delete() : 패스워드가 일치하는지 조사하고 일치할 경우레코드 삭제 -----------------------------
	 public void delete(int rNo, String password) {
		 if( boardDAO.checkPassword(rNo, password) ) {
			 boardDAO.deleteRecord(rNo);
		 }
	 }

}