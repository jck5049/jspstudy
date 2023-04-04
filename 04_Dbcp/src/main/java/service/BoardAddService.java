package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardAddService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 1. 요청 파라미터
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2. BoardDTO 객체 생성
		BoardDTO board = new BoardDTO();
		board.setTitle(title);
		board.setContent(content);
		
		// 3. 삽입을 위해 DB로 BoardDTO를 전달(BoardDAO(<- 접근객체 )의 insertBoard 메소드) 
	    int insertResult = BoardDAO.getInstance().insertBoard(board); // BoardDAO.getInstance() 까지를 DAO라고 함_0이 넘어오면 삽입된 게 없는 거니까 실패, 1이 나오면 성공 
		
	    System.out.println(insertResult == 1 ? "삽입성공" : "삽입실패");
	    
		// 4. 어디로 and 어떻게 이동
		return new ActionForward(request.getContextPath() + "/getAllBoardList.do", true);	// true는 리다이렉트 이동이다.
	}

}
