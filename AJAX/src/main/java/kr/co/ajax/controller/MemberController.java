package kr.co.ajax.controller;


import javax.servlet.http.HttpSession;

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
	////////변진하 로그인 2021/11/25 ////////////
	@PostMapping("/member/login")
	public String login(HttpSession sess, String uid, String pass) {
		  MemberVo vo = service.selectMember(uid, pass);

	  if(vo == null) {
		  // 회원이 아닐경우
		  return "redirect:/member/login?success=100";
	  }else {
		  // 회원이 맞을경우
		  sess.setAttribute("sessMember", vo);
		  return "redirect:/index"; 
	  }
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		// 단순 자료를 지우는 것이기 때문에 post보단 get이 어울린다
		// 현재 사용자 정보객체 세션 삭제
		sess.invalidate();
		return "redirect:/member/login?success=101";
	}

	/////////////////////////////////////
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
