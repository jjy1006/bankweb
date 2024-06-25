package kr.ac.kopo.transaction.dao;

import java.util.List;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.transaction.vo.TransactionVO;

public interface TransactionDAO {

	List<TransactionVO> selectTransactions(Long accountNumber);

	void insertHistory(TransactionVO tran);
}