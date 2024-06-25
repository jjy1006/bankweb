package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {

	/**
	 * 전체게시글 조회
	 */
	List<BoardVO> selectAll() throws Exception;
	
	/**
	 * 글번호로 게시글 조회
	 */
	BoardVO selectByNo(int boardNo) throws Exception;
	
	/**
	 * 새글등록
	 */
	void insert(BoardVO board) throws Exception;
}
