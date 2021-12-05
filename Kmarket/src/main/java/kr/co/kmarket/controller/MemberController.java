package kr.co.kmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	

	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	
	@GetMapping("/member/login")
	public String login(String productCode, String success, Model model) {
		model.addAttribute("productCode", productCode);
		model.addAttribute("success", success);
		return "/member/login";
	}
		
	@PostMapping("/member/login")
	public String login(MemberVo vo, HttpSession sess) {
		
		MemberVo memberVo = service.selectMember(vo);
		
		if(memberVo != null) {
			sess.setAttribute("sessMember", memberVo);
			
			if(vo.getProductCode() > 0) {
				return "redirect:/product/view?productCode="+vo.getProductCode();
			}else {
				return "redirect:/";	
			}
		}else {
			return "redirect:/member/login?success=100";
		}
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(HttpServletRequest req, MemberVo vo) {
		
		String ip = req.getRemoteAddr();
		vo.setIp(ip);
		
		service.insertMember(vo);
		
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/register-seller")
	public String registerSeller() {
		return "/member/register-seller";
	}
	
	@PostMapping("/member/register-seller")
	public String registerSeller(HttpServletRequest req, MemberVo vo) {
		String ip = req.getRemoteAddr();
		vo.setIp(ip);
		
		service.insertMember(vo);
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/signup")
	public String signup(Model model, int type) {
		
		MemberTermsVo vo = service.selectTerms();	
		
		model.addAttribute(vo);
		model.addAttribute("type", type);
		
		return "/member/signup";
	}
	
}
