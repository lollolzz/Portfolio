package kr.co.ajax.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.ajax.service.MemberService;
import kr.co.ajax.vo.MemberVo;
import kr.co.ajax.vo.TermsVo;




@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

	@GetMapping("/member/login")
	public String login(String productCode, String success, Model model) {
		
		model.addAttribute("productCode", productCode); 
		model.addAttribute("success", success);
		
		return "/member/login";
	}
	@PostMapping("/member/login")
	public String login(HttpSession sess, MemberVo vo) {
		
		  MemberVo memberVo = service.selectMember(vo);
		  
		  if(memberVo != null) {// 회원이 맞을경우
			
			  sess.setAttribute("sessMember", memberVo);
			  		  
			  if(vo.getProductCode() > 0) {
				  
					return "redirect:/product/view?productCode="+vo.getProductCode();
				}else {
					return "redirect:/index";
				}	
			  
		  }else {
				// 회원이 아닐경우
					return "redirect:/member/login?success=100";
		  }
	  	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVo vo) {
		
		service.insertMember(vo);
		System.out.println(vo);
		return "redirect:/member/login";
	}
	
	
	@GetMapping("/member/terms")
	public String terms(Model model) {
		
		TermsVo vo = service.selectTerms();
		model.addAttribute("vo", vo);
		
		return "/member/terms";
	}
	
	@ResponseBody
	@GetMapping("/member/checkEmail")
	public String checkEmail(String email) {
		int result = service.selectCountEmail(email);
		// Json 객체 생성 후 클라이언트 전송
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}

	@PostMapping("/member/loginkakao")
	public String loginkakao(HttpSession sess, HttpServletRequest req, MemberVo vo) {

		String uid =  vo.getEmail();
		String email = vo.getEmail();
		String name = vo.getName();
		int gender = vo.getGender();
		String regip = req.getRemoteAddr();
		vo.setIp(regip);
	  MemberVo vo2 = service.selectMember2(email);
	  if(vo2 == null) {
			service.insertMember2(vo);
			service.selectMember2(email);
			sess.setAttribute("sessMember", vo);
			return "redirect:/index"; 
	  }else {
		  // 회원이 맞을경우
		  sess.setAttribute("sessMember", vo2);
		  return "redirect:/index"; 
	  }
		  
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "redirect:/member/login?success=101";
	}
}
	