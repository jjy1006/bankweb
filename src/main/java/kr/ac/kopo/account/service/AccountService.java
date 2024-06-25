package kr.ac.kopo.account.service;

import java.util.List;
import java.util.Map;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.product.vo.ProductVO;

public interface AccountService {

	List<ProductVO> selectProducts();

	void openAccount(AccountVO acc);

	boolean checkAccNum(String accNum);

	List<AccountVO> selectAllAccount(String id);

	List<Integer> selectAllAccNums(String id);

	boolean checkAccNum(Long accNum);

	boolean deposit(String accNum, Long amount);

	boolean sendMoney(Long parseLong, Long parseLong2, Long amount, String pW, String string);

	double getBalance(String accountNumber) throws Exception;

	Map<String, Object> selectTransacionList(Long accountNumber) throws Exception;

	Map<String, Object> selectAccount(Long accountNumber) throws Exception;

	List<String> selectProductNames();

	int getProductNo(String attribute);

	String selectProductName(Long accountNumber);

	boolean withdraw(String accNum, int amount);
}
