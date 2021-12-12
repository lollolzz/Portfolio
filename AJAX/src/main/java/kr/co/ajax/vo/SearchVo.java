package kr.co.ajax.vo;

import lombok.Data;

@Data
public class SearchVo {
	private String keyword;
	private int chk1 = 1;
	private int chk2;
	private int chk3;
	private int min;
	private int max;
	
	//추가필드 I
	private int start;
	private int total;
	private int count;
}
