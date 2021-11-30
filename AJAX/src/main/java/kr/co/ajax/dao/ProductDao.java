package kr.co.ajax.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ajax.vo.CategoriesVo;
import kr.co.ajax.vo.ProductVo;

@Repository
public interface ProductDao {

	public void insertProduct();
	public ProductVo selectProduct(int productCode);
	public int selectProductCountTotal(ProductVo vo);
	public List<ProductVo> selectProducts(ProductVo vo);
	public CategoriesVo selectCategoryTitle(ProductVo vo);
	public void updateProduct();
	public void deleteProduct();
	
}
