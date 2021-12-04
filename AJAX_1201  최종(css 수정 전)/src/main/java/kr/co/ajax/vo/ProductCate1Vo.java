package kr.co.ajax.vo;

import lombok.Data;

@Data
public class ProductCate1Vo {
	
	private int cate1;
	private String title;
	public int getCate1() {
		return cate1;
	}
	public void setCate1(int cate1) {
		this.cate1 = cate1;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
