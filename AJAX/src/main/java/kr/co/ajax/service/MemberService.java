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
	public MemberVo selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	}
	public void selectsMember() {}
	public void updateMember() {}
	public void deleteMember() {}
	
	public TermsVo selectTerms() {
		return dao.selectTerms();
	}
	
	
	
}