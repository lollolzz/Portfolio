package kr.co.ajax.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ajax.vo.ProductCartVo;
import kr.co.ajax.vo.ProductVo;

@Repository
public interface ProductCartDao {

	public void insertCart(ProductCartVo vo);
	public void completeOrder(String uid);
	public void selectCart();
	public List<ProductCartVo> selectCarts(String uid);
	public int selectCountCart(ProductCartVo vo);
	public void updateCart();
	public int deleteCart(int[] cartIds);


}
