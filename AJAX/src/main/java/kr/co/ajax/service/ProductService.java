package kr.co.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ajax.dao.ProductDao;
import kr.co.ajax.vo.CategoriesVo;
import kr.co.ajax.vo.ProductVo;

@Service
public class ProductService {

		@Autowired
		private ProductDao dao;
		public void insertProduct() {}

		public ProductVo selectProduct(int productCode) {
			return dao.selectProduct(productCode);
		}
		
			public List<ProductVo> selectProducts(ProductVo vo) {
				return dao.selectProducts(vo);
			}
			
			public int  selectProductCountTotal(ProductVo vo) {
				return dao.selectProductCountTotal(vo);
			}
			
			public CategoriesVo selectCategoryTitle(ProductVo vo) {
				return dao.selectCategoryTitle(vo);
			}
			public void updateProduct(){}
			public void deleteProduct(){}
			
			//Paging 리스트 시작번호 
			public int getPageStartNum(int total, int start) {
				return total-start;
			}
	
			// 페이지 현재 그룹번호
			public int[] getPageGroup(int currentPage, int lastPageNum) {
				
				int groupCurrent = (int)Math.ceil(currentPage / 16.0);
				int groupStart = (groupCurrent - 1) * 16 + 1;
				int groupEnd = groupCurrent * 16;
		
				if(groupEnd > lastPageNum) {
					groupEnd = lastPageNum;
				}
				
				int[] groups = {groupStart, groupEnd};
		
				return groups;
			}
	
			// 현재 리스트 페이지 번호
			public int getCurrentPage(String pg) {
				int currentPage = 1;
		
				if(pg != null) {
					currentPage = Integer.parseInt(pg);
				}
				return currentPage;
			}
	
			// 현재 리스트 SQL start번호
			public int getLimitStart(int currentPage) {
				return (currentPage - 1) * 16;
			}
	
			// 리스트 마지막 페이지 번호
			public int getLastPageNum(int total) {
				int lastPageNum = 0;
				if(total % 16 == 0) {
					lastPageNum = total / 16;
				}else {
					lastPageNum = total / 16 + 1;
				}
		
				return lastPageNum;
			}

		}