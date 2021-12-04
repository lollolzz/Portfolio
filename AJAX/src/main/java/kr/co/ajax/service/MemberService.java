package kr.co.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ajax.dao.MemberDao;
import kr.co.ajax.vo.MemberVo;
import kr.co.ajax.vo.TermsVo;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public void insertMember(MemberVo vo) {
		dao.insertMember(vo);
	}
	public void insertMember2(MemberVo vo) {
		dao.insertMember2(vo);
	}
	public MemberVo selectMember(MemberVo vo) {
		return dao.selectMember(vo);
	}
	
	public MemberVo selectMember2(String email) {
		return dao.selectMember2(email);
	}
	public void selectsMember() {}
	public void updateMember() {}
	public void deleteMember() {}
	
	public TermsVo selectTerms() {
		return dao.selectTerms();
	}

	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}
	
}