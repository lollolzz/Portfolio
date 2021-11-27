package kr.co.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ajax.dao.ProductCartDao;
import kr.co.ajax.vo.ProductCartVo;
import kr.co.ajax.vo.ProductVo;



@Service
public class ProductCartService {

//  2021.11.24 능한 ProductCartService
	@Autowired
	private ProductCartDao dao;
	
	public void insertCart(ProductCartVo vo) {
		dao.insertCart(vo);
	}
	public void selectCart() {};
	
	public List<ProductCartVo> selectCarts(String uid) {
		return dao.selectCarts(uid);
	};
	
	public int selectCountCart(ProductCartVo vo) {
		return dao.selectCountCart(vo);
	}
	
	public void updateCart() {};
	public int deleteCart(int[] cartIds) {
		return dao.deleteCart(cartIds);
	}
	
	

}
