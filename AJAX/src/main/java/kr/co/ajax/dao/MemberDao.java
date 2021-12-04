package kr.co.ajax.dao;

import org.springframework.stereotype.Repository;

import kr.co.ajax.vo.MemberVo;
import kr.co.ajax.vo.TermsVo;

@Repository
public interface MemberDao {
	
	public void insertMember(MemberVo vo);
	public void insertMember2(MemberVo vo);
	public MemberVo selectMember(MemberVo vo);
	public MemberVo selectMember2(String email);
	public void selectsMembers();
	public void updateMember();
	public void deleteMember();
	
	public TermsVo selectTerms();
	public int selectCountEmail(String email);
	
}