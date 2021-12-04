package kr.co.ajax.vo;

import java.util.List;

import lombok.Data;

@Data
public class CategoriesVo {
	
	private int cate1;
	private int cate2;
	private String tit1;
	private String tit2;
	private List<ProductCate2Vo> cate2List;
	public int getCate1() {
		return cate1;
	}
	public void setCate1(int cate1) {
		this.cate1 = cate1;
	}
	public int getCate2() {
		return cate2;
	}
	public void setCate2(int cate2) {
		this.cate2 = cate2;
	}
	public String getTit1() {
		return tit1;
	}
	public void setTit1(String tit1) {
		this.tit1 = tit1;
	}
	public String getTit2() {
		return tit2;
	}
	public void setTit2(String tit2) {
		this.tit2 = tit2;
	}
	public List<ProductCate2Vo> getCate2List() {
		return cate2List;
	}
	public void setCate2List(List<ProductCate2Vo> cate2List) {
		this.cate2List = cate2List;
	}
	
	
	
	
}
