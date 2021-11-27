package kr.co.farmstory.controller;

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

import kr.co.farmstory.service.MemberService;
import kr.co.farmstory.vo.MemberVo;
import kr.co.farmstory.vo.TermsVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
		
	@GetMapping("/member/login")
	public String login() {

		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String login(HttpSession sess, String uid, String pass) {
	  
	  MemberVo vo = service.selectMember(uid, pass); // if문에서 사용 할거이기 때문에 MemberVo에 담아준다

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
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String regisetr(MemberVo vo, HttpServletRequest req) {

		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		service.insertMember(vo);

		return "redirect:/member/login";
	}

	@GetMapping("/member/terms")
	public String terms(Model model) {
		
		TermsVo vo = service.selectTerms();
		model.addAttribute(vo);
		
		return "/member/terms";
	}
	
	@ResponseBody
	@GetMapping("member/checkUid")
	public String checkUid(String uid) {
		
		//System.out.println("uid : " +uid);
		
		int result = service.selectCountUid(uid);
		
		//Gson라이브러리로 json생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("member/checkNick")
	public String checkNick(String nick) {
		
		int result =service.selectCountNick(nick);
		
		// Json 객체 생성 후 클라이언트 전송
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("member/checkEmail")
	public String checkEmail(String email) {
		int result =service.selectCountEmail(email);
		
		// Json 객체 생성 후 클라이언트 전송
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("member/checkHp")
	public String checkHp(String hp) {
		int result =service.selectCountHp(hp);
		
		// Json 객체 생성 후 클라이언트 전송
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
	
}
