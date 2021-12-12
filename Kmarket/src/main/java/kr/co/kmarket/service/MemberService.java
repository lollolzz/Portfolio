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
	
	public void insertMember(MemberVo mv) {
	      /* Mybatis */
	      dao.insertMember(mv);
	      /* JPA  */
	      /* repo.save(mv); JPA기술로 데이터를 INSERT해주는 메서드 => JPA객체를 상속받았으므로 해당 메서드를 사용합니다.*/
	      /* 쿼리문 작성을 하지 않는다. 즉, 어떤 데이터베이스를 사용하느냐에 따라서 쿼리문이 달라질 수 있는데 무관하게 데이터를 엑세스할 수 있다 표준화하였다. */
	   
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
		MemberTermsVo termsVo = dao.selectTerms();
		
		//JPA 실행
		// MemberTermsVo termsVo = repoTerms.findById(1).get();
						
		return termsVo;
	}
	
	public void updateMember() {}
	public void deleteMember() {}
}



















