package chapter14;

public class BoardService {

	BoardDAO boardDAO;
	
	// BoardService() : 생성자를 이용한 BoardDAO의 객체 생성 ---------------------------------------
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
}
