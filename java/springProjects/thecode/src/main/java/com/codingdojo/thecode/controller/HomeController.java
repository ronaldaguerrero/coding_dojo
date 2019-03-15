package com.codingdojo.thecode.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(HttpSession session) {
		return "home.jsp";
	}
	
	
	@PostMapping("/code")
	private String result(@RequestParam(value="code") String input, RedirectAttributes redirectAttributes) {
		if (input.equals("Bushido")) {
			return "code.jsp";
		} else {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
	
}
