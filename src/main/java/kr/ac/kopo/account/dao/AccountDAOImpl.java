package kr.ac.kopo.account.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.transaction.vo.TransactionVO;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Boolean checkAccNum(Long accNum) {
		return (int)(sqlSession.selectOne("dao.AccountDAO.ckAccnum", accNum))==0;
	}
	
	@Override
	public void insertAccount(AccountVO acc) throws Exception {
		System.out.println(acc);
		sqlSession.insert("dao.AccountDAO.insertAcc",acc);
	}

	@Override
	public List<AccountVO> selectAll(String id) {
		List<AccountVO> accList= sqlSession.selectList("dao.AccountDAO.selectAll",id);
		return accList;
	}

	@Override
	public AccountVO selectAcc(Long accNum) throws Exception{
		AccountVO acc = sqlSession.selectOne("selectOneAcc", accNum);
		return acc;
		
	}

	@Override
	public List<Integer> selectAccNums(String id) {
		List<Integer> accList = sqlSession.selectList("dao.AccountDAO.selectAccNums",id);
		return accList;
	}

	@Override
	public void updateBalance(String accountNumber, Long newBalance) throws Exception {
		AccountVO acc = new AccountVO();
	    acc.setAccountNumber(accountNumber);
	    acc.setBalance(newBalance); // double 값을 String으로 변경하여 설정
	    sqlSession.update("dao.AccountDAO.updateBalance", acc);
	}
	@Override
	public Long getBalance(String accNum) {
		return sqlSession.selectOne("dao.AccountDAO.getBalance", Long.parseLong(accNum));
	}

	@Override
	public Boolean checkPW(AccountVO acc) {
		return (int)sqlSession.selectOne("dao.AccountDAO.ckPW", acc)==1;
	}
	@Override
    public double getBalance2(String accNum) throws Exception {
        return sqlSession.selectOne("dao.AccountDAO.getBalance2",  Long.parseLong(accNum));
    }

  @Override
  public void updateBalance2(String accountNumber, double newBalance) throws Exception {
      AccountVO params = new AccountVO();
      params.setAccountNumber(accountNumber);
      params.setBalance((long)newBalance); // double 값을 String으로 변경하여 설정
      sqlSession.update("dao.AccountDAO.updateBalance", params);
  }

	@Override
	public void deleteAccs(String id) {
		sqlSession.delete("deleteAcccountByOnwerId",id);
	}


	/*
	@Override
	public AccountVO select(AccountVO member) throws Exception {
		AccountVO loginVO = sqlSession.selectOne("dao.MemberDAO.login", member);
		return loginVO;
	}
	@Override
	public Boolean checkById(String id) throws Exception {
		AccountVO cm = sqlSession.selectOne("checkById",id);
		return cm==null;//데이터 삽입 가능:true
	}
	
	@Override
	public void updateCustomer(AccountVO cm) throws Exception {
		sqlSession.update("updateCustomer",cm);
	}
	
	@Override
	public void deleteCustomer(String id) throws Exception {
		sqlSession.delete("deleteCustomer",id);
	}
	*/

}
