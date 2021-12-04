package kr.co.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCotroller {

	@GetMapping(value = {"/index", "/"})
	public String index() {
		return "/index";
	}
	
	
	@GetMapping("/about/aboutus")
	public String aboutus() {
		return "/about/aboutus";
	}
	
}
