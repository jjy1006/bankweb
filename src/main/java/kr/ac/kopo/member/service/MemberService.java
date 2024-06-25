package kr.ac.kopo.member.service;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberService {

	Boolean signup(MemberVO member) throws Exception;

	void updateCustomer(MemberVO cm) throws Exception;

	void deleteCustomer(String id) throws Exception;

	MemberVO login(MemberVO member) throws Exception;

	boolean checkPassword(String id, String password) throws Exception;

}
