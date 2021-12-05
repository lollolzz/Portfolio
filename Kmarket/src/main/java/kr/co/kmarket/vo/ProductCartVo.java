package kr.co.kmarket.vo;

import lombok.Data;

@Data
public class ProductCartVo {
	private int cartId;
	private String uid;
	private int productCode;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int delivery;
	private int total;
	private String rdate;
	
	// 추가필드
	private int cate1;
	private int cate2;
	private String name;
	private String thumb1;
}
