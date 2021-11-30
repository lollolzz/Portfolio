package kr.co.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ajax.dao.ProductOrderDao;
import kr.co.ajax.vo.ProductOrderVo;

@Service
public class ProductOrderService {
	
	@Autowired
	private ProductOrderDao dao;
	
	public void insertOrder(ProductOrderVo vo) {
		dao.insertOrder(vo);
	}
	public void selectOrder() {}
	public List<ProductOrderVo> selectOrders(int orderId) {
		return dao.selectOrders(orderId);
	}
	public void updateOrder() {}
	public void deleteOrder() {}
	
	

}
