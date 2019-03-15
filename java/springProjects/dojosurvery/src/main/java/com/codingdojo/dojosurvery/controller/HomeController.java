package com.codingdojo.dojosurvery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(HttpSession session) {
		return "home.jsp";
	}
	
	@PostMapping("/register")
	public String register(
			@RequestParam(value="name") String name,
			@RequestParam(value="loc") String loc,
			@RequestParam(value="lang") String lang,
			@RequestParam(value="comm") String comm, 
			HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("loc", loc);
		session.setAttribute("lang", lang);
		session.setAttribute("comm", comm);
		return "redirect:/result";
	}
	
	@GetMapping("/result")
	public String result() {
		return "result.jsp";
	}
}
