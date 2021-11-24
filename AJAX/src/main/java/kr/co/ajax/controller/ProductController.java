package kr.co.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductController {	
	
	
//	@Autowired
//	private ProductCartService cartService;
	
	
//  2021.11.24 능한 cart controller
//	@GetMapping("/product/cart")
//	public String cart(HttpSession sess, Model model) {
//		
//		// 로그인 여부확인
//		MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
//		
//		if(vo != null) {
//			
//			List<ProductCartVo> cartProducts = cartService.selectCarts(vo.getUid());
//			model.addAttribute("cartProducts", cartProducts);
//			
//			return "/product/cart";
//		}else {
//			return "redirct:/member/login";
//		}
//
//	}
//	
//	
//	@ResponseBody
//	@PostMapping("/product/cart")
//	public String cart(ProductCartVo vo) {
//		
//		int result = cartService.selectCountCart(vo);
//		
//		if(result == 0) {
//			cartService.insertCart(vo);	
//		}
//		
//		System.out.println("result : "+result);
//		
//		JsonObject json = new JsonObject();
//		json.addProperty("result", result);
//		
//		return new Gson().toJson(json);
//	}
//	
//	@ResponseBody
//	@GetMapping("/product/cartDelete")
//	public String cartDelete(int[] cartIds) {
//		
//		int result = cartService.deleteCart(cartIds);
//		
//		JsonObject json = new JsonObject();
//		json.addProperty("result", result);
//		
//		return new Gson().toJson(json);
//	}
	
	@GetMapping("/product/cart")
	public String cart() {
		return "/product/cart";
	}
	
	
	
	@GetMapping("/product/list")
	public String list() {
		return "/product/list";
	}
	
	@GetMapping("/product/payment")
	public String payment() {
		return "/product/payment";
	}
	
	@GetMapping("/product/view")
	public String view() {
		return "/product/view";
	}
	
	@GetMapping("/product/delivery")
	public String delivery() {
		return "/product/delivery";
	}
	
	
	
	
}
