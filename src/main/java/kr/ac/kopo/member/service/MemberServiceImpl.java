package kr.ac.kopo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.account.dao.AccountDAO;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private AccountDAO accountDao;
	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public MemberVO login(MemberVO member) throws Exception {
		return memberDao.login(member);
	}
	@Override
	public Boolean signup(MemberVO member) throws Exception {
		if(memberDao.checkById(member.getId()) && memberDao.checkByAdminId(member.getId())) {
			memberDao.insertCustomer(member);
			return true;
		}
		return false;
	}
	
	@Override
	public void updateCustomer(MemberVO cm) throws Exception {
		memberDao.updateCustomer(cm);
	}

	@Override
	public void deleteCustomer(String id) throws Exception {
		accountDao.deleteAccs(id);
		memberDao.deleteCustomer(id);
	}
	
	@Override
    public boolean checkPassword(String id, String password) throws Exception {
        MemberVO member = new MemberVO();
        member.setId(id);
        member.setPassword(password);
        return memberDao.checkPassword(member);
    }
	
}
