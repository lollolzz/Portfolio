package kr.co.ajax.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ajax.service.MemberService;
import kr.co.ajax.vo.MemberVo;
import kr.co.ajax.vo.TermsVo;




@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVo vo) {
		
		service.insertMember(vo);
		
		return "redirect:/index";
	}
	
	
	@GetMapping("/member/terms")
	public String terms(Model model) {
		
		TermsVo vo = service.selectTerms();
		model.addAttribute("vo", vo);
		
		return "/member/terms";
	}

}
