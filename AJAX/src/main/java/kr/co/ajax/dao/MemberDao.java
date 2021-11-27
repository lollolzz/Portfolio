package kr.co.ajax.dao;

import org.springframework.stereotype.Repository;

import kr.co.ajax.vo.MemberVo;
import kr.co.ajax.vo.TermsVo;

@Repository
public interface MemberDao {
	
	public void insertMember(MemberVo vo);
	
	public MemberVo selectMember(String uid, String pass);
	public void selectsMembers();
	public void updateMember();
	public void deleteMember();
	
	public TermsVo selectTerms();
	
	
}
