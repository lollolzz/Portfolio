package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MemberDao;
import kr.co.kmarket.dao.MemberRepo;
import kr.co.kmarket.dao.MemberTermsRepo;
import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private MemberRepo repo;
	
	@Autowired
	private MemberTermsRepo repoTerms;
	
	public void insertMember(MemberVo vo) {
		//Mybatis 실행
		//dao.insertMember(vo);
		
		//JPA 실행
		repo.save(vo);		
	}
	public MemberVo selectMember(MemberVo vo) {
		
		//Mybatis 실행
		MemberVo memberVo = dao.selectMember(vo);
		
		//JPA 실행
		//MemberVo memberVo = repo.findby();
		
		return memberVo;
	}
	public void selectMembers() {}
	
	public MemberTermsVo selectTerms() {
		//Mybatis 실행
		//MemberTermsVo termsVo = dao.selectTerms();
		
		//JPA 실행
		MemberTermsVo termsVo = repoTerms.findById(1).get();
						
		return termsVo;
	}
	
	public void updateMember() {}
	public void deleteMember() {}
}



















