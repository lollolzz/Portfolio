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
import kr.co.ajax.service.ProductReviewService;
import kr.co.ajax.service.ProductService;
import kr.co.ajax.vo.CategoriesVo;
import kr.co.ajax.vo.MemberVo;
import kr.co.ajax.vo.ProductCartVo;
import kr.co.ajax.vo.ProductOrderVo;
import kr.co.ajax.vo.ProductReviewVo;
import kr.co.ajax.vo.ProductVo;


@Controller
public class ProductController {	
	
	@Autowired
	private ProductService service;
	
	// 2021.11.27 권능한 작업 수정
	@Autowired
	private ProductCartService cartService;
	
	@Autowired
	private ProductOrderService orderService;
	
	//시현 20211126
		@Autowired
		private ProductReviewService reviewService;
	//시현 여기까지
	

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
	public String list(ProductVo vo, Model model, String pg) {
			
			// 리스트 번호 처리
			int currentPage = service.getCurrentPage(pg);
			int start = service.getLimitStart(currentPage);
			int total = service.selectProductCountTotal(vo);
			int pageStartNum = service.getPageStartNum(total, start);
			int lastPageNum = service.getLastPageNum(total);
			int groups[] = service.getPageGroup(currentPage, lastPageNum);
			
			
//			System.out.println("start : "+start);
//			System.out.println("total : "+total);
//			System.out.println("groups[0] : "+groups[0]);
//			System.out.println("groups[1] : "+groups[1]);

			vo.setStart(start);

			List<ProductVo> products = service.selectProducts(vo);
			CategoriesVo cateVo = service.selectCategoryTitle(vo);

			
			model.addAttribute("products",products);
			//view로 연결 - 시현 추가 작업
			model.addAttribute("productCode", vo.getProductCode());
			
			model.addAttribute("totalCount", products.size()); // 각 카테고리의아이템 갯수를 나타내기 위해 List의 size를 활
			model.addAttribute("cateVo", cateVo);
			model.addAttribute("order",vo.getOrder());
			
			
			model.addAttribute("pageStartNum", pageStartNum);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("lastPageNum", lastPageNum);
			model.addAttribute("groups", groups);
			
			return "/product/list";
		}
	
	
	@ResponseBody
	@PostMapping("/product/payment")
	public String payment(ProductOrderVo vo) {
		
		System.out.println("1");
		
		// 배송 정보 테이블 저장
		orderService.insertOrder(vo);
		
		// 주문 테이블 Insert 후 주문번호 가져오기
		int orderId = vo.getOrderId();
		
		// 주문번호 상품코드 입력하기
		int i = 0;
		int[] productCounts = vo.getProductCounts();
		
		JsonObject json = new JsonObject();
		json.addProperty("orderId", orderId);
		
		return new Gson().toJson(json);
	}
	
	
	@GetMapping("/product/delivery")
	public String order(int orderId, Model model) {

		List<ProductOrderVo> orderProducts = orderService.selectOrders(orderId);
		model.addAttribute("orderProducts", orderProducts);
		model.addAttribute("productOrderVo", orderProducts.get(0));
		return "/product/delivery";
	}
	
	@GetMapping("/product/payment")
	public String payment(int orderId, Model model) {
		List<ProductOrderVo> orderProducts = orderService.selectOrders(orderId);

		model.addAttribute("orderProducts", orderProducts);
		model.addAttribute("productOrderVo", orderProducts.get(0));
		return "/product/payment";
	}
	@ResponseBody
	@PostMapping("/product/delivery")
	public String order(ProductOrderVo vo) {
		
		
//		// 장바구니 주문한 상품 삭제
//		cartService.deleteCart(vo.getCartIds());
		
	    // 장바구니 상품 주문 테이블 저장
		orderService.insertOrder(vo);
		
		// 주문 테이블 Insert 후 주문번호 가져오기
		int orderId = vo.getOrderId();
	
//		// 주문번호 상품코드 입력하기
//		int i = 0;
//		int[] productCounts = vo.getProductCounts();
//		
//		for(int productCode : vo.getProductCodes()) {
//			orderService.insertOrderDetail(orderId, productCode, productCounts[i]);
//			i++;
//		}
		
		JsonObject json = new JsonObject();
		json.addProperty("orderId", orderId);
		
		return new Gson().toJson(json);
	}
	
	// 2021.11.27 권능한 작업 수정 
	
	
		
	// 시현 20211125 view페이지 관련
		@GetMapping("/product/view")
		public String view(int productCode, Model model, String pg) {
			
			System.out.println("productCode : "+productCode);
			
			//뷰 페이지에 출력할 해당 상품정보 DB에서 가져오기
			ProductVo product = service.selectProduct(productCode);
					
			//페이지 처리
			int currentPage = reviewService.getCurrentPage(pg); 
			int start = reviewService.getLimitStart(currentPage);
			int total = reviewService.selectCountTotal(productCode); //전체 게시물 개수니까 쿼리문 날려야 함 -- 쿼리문작업하고돌아와
			int lastPageNum = reviewService.getLastPageNum(total);
			int groups[] = reviewService.getPageGroup(currentPage, lastPageNum);
			
			//뷰 페이지에 출력할 해당 상품 리뷰정보 DB에서 가져오기
			List<ProductReviewVo> productReviews =  reviewService.selectReviews(productCode, start);
			
			//뷰에 출력할 데이터 참조 시키기
			model.addAttribute("product" , product);
			model.addAttribute("productCode" , productCode);
			model.addAttribute("productReviews", productReviews);
			
			model.addAttribute("currentPage", currentPage); 
			model.addAttribute("lastPageNum", lastPageNum); 
			model.addAttribute("groups", groups); 
			
			// 뷰 출력하기
			return "/product/view";
		}
		
		//시현 20211126 상품리뷰 관련
		@ResponseBody
		@GetMapping("/product/review")
		public List<ProductReviewVo> view(int productCode, int reviewPageNum) {
			
			int start = (reviewPageNum - 1) * 5;
			List<ProductReviewVo> reviews = reviewService.selectReviews(productCode, start);
			return reviews;
		}//시현 여기까지
	
		@PostMapping("/product/completeOrder")
		public String completeOrder(HttpSession sess) {
			MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
			String uid = vo.getUid();
			cartService.completeOrder(uid);	
			return "/index";
		}
	
}
