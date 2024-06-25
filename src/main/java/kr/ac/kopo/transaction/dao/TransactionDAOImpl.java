package kr.ac.kopo.transaction.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.transaction.vo.TransactionVO;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<TransactionVO> selectTransactions(Long accountNumber) {
		System.out.println(accountNumber);
		return sqlSession.selectList("selectTransactions",accountNumber);
	}

	@Override
	public void insertHistory(TransactionVO tran) {
		sqlSession.selectList("insertHistory",tran);
	}
	
}
