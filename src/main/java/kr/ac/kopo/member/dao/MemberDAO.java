package kr.ac.kopo.member.dao;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberDAO {

	MemberVO login(MemberVO member) throws Exception;
	Boolean checkById(String id) throws Exception;
	void updateCustomer(MemberVO cm) throws Exception;
	void deleteCustomer(String id) throws Exception;
	void insertCustomer(MemberVO cm) throws Exception;
	Boolean checkPassword(MemberVO member) throws Exception;
	Boolean checkByAdminId(String id) throws Exception;
	
}
