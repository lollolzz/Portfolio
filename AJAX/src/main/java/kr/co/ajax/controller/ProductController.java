package kr.co.ajax.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.ajax.service.ProductCartService;
import kr.co.ajax.service.ProductOrderService;
import kr.co.ajax.vo.MemberVo;
import kr.co.ajax.vo.ProductCartVo;


@Controller
public class ProductController {	
	
	// 2021.11.27 권능한 작업 수정
	@Autowired
	private ProductCartService cartService;
	
	@Autowired
	private ProductOrderService orderService;

	@GetMapping("/product/cart")
	public String cart(HttpSession sess, Model model) {
		
		// 로그인 여부확인
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
		
		if(vo != null) {
			
			String uid = vo.getUid();
			
			List<ProductCartVo> cartProducts = cartService.selectCarts(uid);
					
			model.addAttribute("cartProducts", cartProducts);
			
			return "/product/cart";
			
		}else {
			
			return "redirect:/member/login";
		}

	}

	@ResponseBody
	@PostMapping("/product/cart")
	public String cart(ProductCartVo vo) {
		
		int result = cartService.selectCountCart(vo);
		
		if(result == 0) {
			cartService.insertCart(vo);	
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("/product/cartDelete")
	public String cartDelete(int[] cartIds) {
		
		int result = cartService.deleteCart(cartIds);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@GetMapping("/product/list")
	public String list() {
		return "/product/list";
	}
	
	@GetMapping("/product/payment")
	public String payment() {
		return "/product/payment";
	}
	
	
//	@GetMapping("/product/payment")
//	public String order(int orderId, Model model) {
//		
//		List<ProductOrderVo> orderProducts = orderService.selectOrders(orderId);
//		model.addAttribute("orderProducts", orderProducts);
//		model.addAttribute("productOrderVo", orderProducts.get(0));
//		
//		return "/product/payment";
//	}

//	@ResponseBody
//	@PostMapping("/product/payment")
//	public String order(ProductOrderVo vo) {
		
//		// 장바구니 주문한 상품 삭제
//		cartService.deleteCart(vo.getCartIds());
//		
//		// 장바구니 상품 주문 테이블 저장
//		orderService.insertOrder(vo);
//		
//		// 주문 테이블 Insert 후 주문번호 가져오기
//		int orderId = vo.getOrderId();
//		
//		// 주문번호 상품코드 입력하기
//		int i = 0;
//		int[] productCounts = vo.getProductCounts();
//		
//		for(int productCode : vo.getProductCodes()) {
//			orderService.insertOrderDetail(orderId, productCode, productCounts[i]);
//			i++;
//		}
//		
//		JsonObject json = new JsonObject();
//		json.addProperty("orderId", orderId);
//		
//		return new Gson().toJson(json);
//	}
	
	// 2021.11.27 권능한 작업 수정 
	
	
	@GetMapping("/product/view")
	public String view() {
		return "/product/view";
	}
	
	@GetMapping("/product/delivery")
	public String delivery() {
		return "/product/delivery";
	}
	
	
	
	
}
