package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		
		// 메인상품 조회
		List<ProductVo> productsHit       = service.selectMainProduct("hit");		
		List<ProductVo> productsBest      = service.selectMainProduct("sold");
		//List<ProductVo> productsRecommend = service.selectMainProduct("score");
		//List<ProductVo> productsLatest    = service.selectMainProduct("rdate");
		//List<ProductVo> productsDiscount  = service.selectMainProduct("discount");
		
		
		model.addAttribute("productsHit", productsHit);		
		model.addAttribute("productsBest", productsBest);
		//model.addAttribute("productsRecommend", productsRecommend);
		//model.addAttribute("productsLatest", productsLatest);
		//model.addAttribute("productsDiscount", productsDiscount);
		
		return "/index";
	}
	
	@ResponseBody
	@GetMapping("/getCategories")
	public List<CategoriesVo> getCategories() {
		List<CategoriesVo> cates = service.selectCategories();
		return cates;
	}
	
	@ResponseBody
	@GetMapping("/getMainProduct")
	public List<ProductVo> getMainProduct(String order) {
		List<ProductVo> products = service.selectMainProduct(order);
		return products;
	}
	
	

}
