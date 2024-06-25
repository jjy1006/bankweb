package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardVO> selectAll() throws Exception {
		List<BoardVO> list = sqlSession.selectList("dao.BoardDAO.selectBoard");
		return list;
	}

	@Override
	public BoardVO selectByNo(int boardNo) throws Exception {
		BoardVO board = sqlSession.selectOne("dao.BoardDAO.selectBoardByNo", boardNo);
		return board;
	}

	@Override
	public void insert(BoardVO board) throws Exception {
		sqlSession.insert("dao.BoardDAO.insertBoard", board);
	}
	

}
