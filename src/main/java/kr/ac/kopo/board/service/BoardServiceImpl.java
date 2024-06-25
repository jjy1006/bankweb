package kr.ac.kopo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public List<BoardVO> searchAllBoard() throws Exception {
		List<BoardVO> list = boardDao.selectAll();
		return list;
	}

	@Override
	public BoardVO searchBoardByNo(int boardNo) throws Exception {
		BoardVO board = boardDao.selectByNo(boardNo);
		return board;
	}

	@Override
	public void addBoard(BoardVO board) throws Exception {

		boardDao.insert(board);
		
	}
	
	

}
