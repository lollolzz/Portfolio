package kr.co.kmarket.vo;

import lombok.Data;

@Data
public class ProductOrderReviewVo {

	private int reviewId;
	private int productCode;
	private String content;
	private String uid;
	private int rating;
	private String ip;
	private String rdate;
}
