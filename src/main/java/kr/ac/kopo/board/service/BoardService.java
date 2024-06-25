package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardService {

	List<BoardVO> searchAllBoard() throws Exception;
	
	BoardVO searchBoardByNo(int boardNo) throws Exception;
	
	void addBoard(BoardVO board) throws Exception;
}
