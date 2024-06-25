package kr.ac.kopo.account.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.account.dao.AccountDAO;
import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.product.dao.ProductDAO;
import kr.ac.kopo.product.vo.ProductVO;
import kr.ac.kopo.transaction.dao.TransactionDAO;
import kr.ac.kopo.transaction.vo.TransactionVO;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private ProductDAO productDao;
	@Autowired
	private AccountDAO accountDao;
	@Autowired
	private TransactionDAO transactionDao;

	@Override
	public List<ProductVO> selectProducts() {
		List<ProductVO> products = productDao.selectAllProducts();
		return products;
	}

	@Override
	public void openAccount(AccountVO acc) {
		try {
			accountDao.insertAccount(acc);
		} catch (Exception e) {
			System.out.println("AccountDao.open에서 에러");
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkAccNum(Long accNum) {
		return accountDao.checkAccNum(accNum);
	}

	@Override
	public List<AccountVO> selectAllAccount(String id) {
		List<AccountVO> accList= accountDao.selectAll(id);
		return accList;
	}

	@Override
	public Map<String, Object> selectAccount(Long accountNumber) throws Exception {
		Map<String, Object> prodAndAcc = new HashMap<>();
		AccountVO account = accountDao.selectAcc(accountNumber);
		prodAndAcc.put("accountVO", account);
		prodAndAcc.put("productType", productDao.selectProductType(account.getProductNo()));
		return prodAndAcc;
	}
	
	@Override
	public List<Integer> selectAllAccNums(String id) {
		List<Integer> accList= accountDao.selectAccNums(id);
		return accList;
	}

	@Override
	public boolean checkAccNum(String accNum) {
		return accountDao.checkAccNum(Long.parseLong(accNum));
	}

	@Override
	public boolean deposit(String accNum, Long amount) {
		try {
			AccountVO acc = accountDao.selectAcc(Long.parseLong(accNum));
			int currentBalance = acc.getBalance().intValue();
            accountDao.updateBalance(accNum, (currentBalance + amount));
            TransactionVO tran = new TransactionVO();
            tran.setTransactionType("입금");
            tran.setReceiverAccountnumber(accNum);
            tran.setTransferAmount(amount.intValue());
            tran.setAfterBalance((int)(currentBalance+amount));
            transactionDao.insertHistory(tran);
            return true; // 입금 성공
		} catch (Exception e) {
        	e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean sendMoney(Long senderAccNum, Long receiverAccNum
							, Long amount, String PW,String id) {
		AccountVO acc = new AccountVO();
		acc.setAccountNumber(Long.toString(senderAccNum));
		acc.setTransferPassword(Integer.parseInt(PW));
		acc.setOnwerId(id);
		try {
			Long balance = accountDao.getBalance(Long.toString(senderAccNum));
			if(accountDao.checkPW(acc) && balance >= amount) {
				accountDao.updateBalance(Long.toString(senderAccNum),
						(accountDao.getBalance(Long.toString(senderAccNum))-amount));
				accountDao.updateBalance(Long.toString(receiverAccNum),
						(accountDao.getBalance(Long.toString(receiverAccNum))+amount));
				TransactionVO tran = new TransactionVO();
				tran.setTransactionType("이체");
				tran.setSenderAccountnumber(Long.toString(senderAccNum));
				tran.setReceiverAccountnumber(Long.toString(receiverAccNum));
				tran.setTransferAmount(amount.intValue());
				tran.setAfterBalance((int)(balance-amount));
				transactionDao.insertHistory(tran);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	@Override
    public double getBalance(String accountNumber) throws Exception {
        // 해당 계좌번호의 잔액을 조회하는 로직을 구현
        // 예시: AccountDAO를 이용하여 해당 계좌번호의 잔액을 조회하는 코드를 작성
        double balance = accountDao.getBalance(accountNumber);
        return balance;
    }

	@Override
    public boolean withdraw(String accNum, int amount) {
        try {
            double currentBalance = accountDao.getBalance2(accNum);
            if (currentBalance < amount) {
                return false; // 잔액 부족
            }
        	AccountVO acc = accountDao.selectAcc(Long.parseLong(accNum));
        	int balance = acc.getBalance().intValue();
        	TransactionVO tran = new TransactionVO();
        	tran.setTransactionType("출금");
        	tran.setSenderAccountnumber(accNum);
        	tran.setTransferAmount(amount);
        	tran.setAfterBalance(balance-amount);
        	transactionDao.insertHistory(tran);
            accountDao.updateBalance2(accNum, currentBalance - amount);
            
            // 출금 거래 로그 추가
            try {
                accountDao.selectAcc(Long.parseLong(accNum));
                //accountDao.addTransactionLog("Withdraw", accNum, null, amount, new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true; // 출금 성공
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public Map<String, Object> selectTransacionList(Long accountNumber) throws Exception{
		System.out.println("accdao selTrans tran test");
		//acc,tran return
		Map<String, Object> map = new HashMap<String, Object>();
		AccountVO acc = accountDao.selectAcc(accountNumber);
		List<TransactionVO> trans = transactionDao.selectTransactions(accountNumber);
		for(TransactionVO transaction:trans) {
			System.out.println("accdao selTrans tran:"+transaction);
		}
		System.out.println("acc service selTrans : "+trans);
		map.put("account", acc);
		map.put("trans", trans);
		return map;
	}

	@Override
	public List<String> selectProductNames() {
		return productDao.selectAllProductNames();
	}

	@Override
	public int getProductNo(String productName) {
		List<Integer> list = productDao.getProductByName(productName);
		return list.get(0);
	}

	@Override
	public String selectProductName(Long accountNumber) {
		return productDao.selectProductName(accountNumber);
	}
	
	
//	
//	@Override
//	public AccountVO selectAccount(AccountVO account) throws Exception {
//		return accountDao.select(account);
//	}
//	@Override
//	public Boolean signup(AccountVO account) throws Exception {
//		if(accountDao.checkById(account.getAccountNumber())) {
//			accountDao.insertCustomer(account);
//			return true;
//		}
//		return false;
//	}
//	
//	@Override
//	public void updateAccount(AccountVO account) throws Exception {
//		accountDao.updateCustomer(account);
//	}
//
//	@Override
//	public void deleteAccount(String id) throws Exception {
//		accountDao.deleteCustomer(id);
//	}
	
}
