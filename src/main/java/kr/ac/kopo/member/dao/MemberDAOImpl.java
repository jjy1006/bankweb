package kr.ac.kopo.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberVO login(MemberVO member) throws Exception {
		MemberVO mb = sqlSession.selectOne("dao.MemberDAO.login", member);
		if(mb==null) {
			mb = sqlSession.selectOne("dao.MemberDAO.adminLogin", member);
			if(mb!=null) {
				mb.setType("A");
			}
		}else {
			mb.setType("U");
		}
		return mb;
	}
	
	@Override
	public Boolean checkById(String id) throws Exception {
		MemberVO cm = sqlSession.selectOne("checkById",id);
		return cm==null;//데이터 삽입 가능:true
	}
	@Override
	public Boolean checkByAdminId(String id) throws Exception {
		MemberVO cm = sqlSession.selectOne("checkByAdminId",id);
		return cm==null;//데이터 삽입 가능:true
	}

	@Override
	public void insertCustomer(MemberVO cm) throws Exception {
		sqlSession.insert("signup",cm);
	}

	@Override
	public void updateCustomer(MemberVO cm) throws Exception {
		sqlSession.update("updateCustomer",cm);
	}

	@Override
	public void deleteCustomer(String id) throws Exception {
		sqlSession.delete("deleteCustomer",id);
	}
	
	@Override
    public Boolean checkPassword(MemberVO member) throws Exception {
        return !(sqlSession.selectOne("dao.MemberDAO.login", member)==null);
    }

	
}
