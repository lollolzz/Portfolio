package kr.co.ajax.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ajax.vo.ProductOrderVo;

@Repository
public interface ProductOrderDao {
	
	
	public void insertOrder(ProductOrderVo vo);
	public void selectOrder();
	public List<ProductOrderVo> selectOrders(int orderId);
	public void updateOrder();
	public void deleteOrder();

}
