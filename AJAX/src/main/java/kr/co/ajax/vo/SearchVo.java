package kr.co.ajax.vo;

import lombok.Data;

@Data
public class SearchVo {
	private String keyword;
	private int chk1 = 1;
	private int chk2;
	
	//추가필드 I
	private int start;
	private int total;
	private int count;
	private int order = 1;
}
