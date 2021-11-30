package kr.co.ajax.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ajax.vo.ProductReviewVo;
import kr.co.ajax.vo.ProductVo;


@Repository
public interface ProductReviewDao {
	
	public void insertReview();
	public String selectReview(int productCode);
	public List<ProductReviewVo> selectReviews(int productCode, int start);
	public int selectCountTotal(int productCode);
	public void updateReview();
	public void deleteReview();

}
