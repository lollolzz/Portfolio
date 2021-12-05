package kr.co.kmarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.kmarket.vo.MemberTermsVo;

public interface MemberTermsRepo extends JpaRepository<MemberTermsVo, Integer>{

}
