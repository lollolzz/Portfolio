package kr.co.kmarket.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVo {
	private int productCode;
	private int cate1;
	private int cate2;
	private String name;
	private String descript;
	private String company;
	private String seller;
	private int price;
	private int discount;
	private int point;
	private int stock;
	private int sold;
	private int delivery;
	private int hit;
	private int score;
	private int review;
	private String thumb1;
	private String thumb2;
	private String thumb3;
	private String detail;
	private String status;
	private String dutyFree;
	private String receipt;
	private String bizClass;
	private String origin;
	private String ip;
	private String rdate;
	private int etc1;
	private int etc2;
	private String etc3;
	private String etc4;
	private String etc5;
	
	//추가필드 I
	private int salePrice;
	private String tit1;
	private String tit2;
	private int order = 1;
	private int start;
	
	//추가필드 II
	private MultipartFile thumbFile1;
	private MultipartFile thumbFile2;
	private MultipartFile thumbFile3;
	private MultipartFile detailFile4;
	
	public List<MultipartFile> getFiles() {
		List<MultipartFile> files = Arrays.asList(thumbFile1, thumbFile2, thumbFile3, detailFile4);
		return files;
	}
}









