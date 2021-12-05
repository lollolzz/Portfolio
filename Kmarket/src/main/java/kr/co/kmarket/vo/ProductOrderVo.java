package kr.co.kmarket.vo;

import lombok.Data;

@Data
public class ProductOrderVo {

	private int orderId;
	private String uid;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int usePoint;
	private int delivery;
	private int total;
	private String orderer;
	private String hp;
	private String zip;
	private String addr1;
	private String addr2;
	private int payment;
	private int complete;
	private String rdate;
	private String completeDate;
	
	// 추가필드I
	private int[] cartIds;
	private int[] productCodes;
	private int[] productCounts;
	
	// 추가필드II
	private int productCode;
	private int pCount;
	private int cate1;
	private int cate2;
	private String thumb1;
	private String pName;
	private int pPrice;
	private int pDiscount;
	private int pPoint;
	private int pDelivery;
	private int salePrice;
	private String uName;
	private String uHp;
	private String uZip;
	private String uAddr1;
	private String uAddr2;
	private int uPoint;
}
















