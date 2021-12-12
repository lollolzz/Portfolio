package kr.co.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ajax.dao.ProductDao;
import kr.co.ajax.dao.ProductReviewDao;
import kr.co.ajax.vo.ProductReviewVo;

@Service
public class ProductReviewService {
	
	// 시현 2021.11.25 상품상세 페이지 리뷰 불러오기 및 페이징 
	@Autowired
	private ProductDao dao;
	
	@Autowired
	private ProductReviewDao reviewDao;
	
	public void insertReview() {}
	
	public String selectReview(int productCode){
		return reviewDao.selectReview(productCode);
	}
	
	
	public List<ProductReviewVo> selectReviews(int productCode, int start){		
		return reviewDao.selectReviews(productCode, start); 
	}
	public int selectCountTotal(int productCode) {
		return reviewDao.selectCountTotal(productCode);
	}
	public void updateReview(){}
	public void deleteReview(){}
	
	
	//////페이지 처리를 위한 메서드 
	
	//페이지 리스트 시작번호 
	public int getPageStartNum(int total, int start) {
		return total - start;
	}
	//페이지 현재 그룹번호(이전, 다음 계산 위함)
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		int groupCurrent = (int) Math.ceil(currentPage / 5.0); 
		int groupStart = (groupCurrent - 1) * 5 + 1;
		int groupEnd = groupCurrent * 5;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		int[] groups = {groupStart, groupEnd};
		
		return groups;
	}
	
	//현재 리스트 페이지 번호
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	
	//현재 리스트 SQL start번호 (쿼리문에 사용될 start번호)
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 5;
	}
	
	//리스트 마지막 페이지 번호
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		if(total % 5 == 0) {
			lastPageNum = total / 5;
		}else {
			lastPageNum = total / 5 + 1;
		}
		return lastPageNum;
	}
	
	
	
	
	
	
	
	
}
