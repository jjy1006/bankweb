package kr.ac.kopo.account.dao;

import java.util.List;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.transaction.vo.TransactionVO;

public interface AccountDAO {

	Boolean checkAccNum(Long accNum);

	void insertAccount(AccountVO acc) throws Exception;

	List<AccountVO> selectAll(String id);

	AccountVO selectAcc(Long accountNumber) throws Exception;

	List<Integer> selectAccNums(String id);

	Long getBalance(String string);

	void updateBalance(String accountNumber, Long newBalance) throws Exception;

	Boolean checkPW(AccountVO acc);

	void updateBalance2(String accountNumber, double newBalance) throws Exception;

	double getBalance2(String accNum) throws Exception;

	void deleteAccs(String id);
}