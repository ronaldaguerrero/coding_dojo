package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(HttpSession session) {
		if (session.isNew()) {
			Integer counter = 0;
			session.setAttribute("count", counter);
			Integer count = (Integer) session.getAttribute("count");
		} else {
			Integer count = (Integer) session.getAttribute("count");
			session.setAttribute("count", count+1);
		}
		return "home.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		session.setAttribute("count", 0);
		return "counter.jsp";
	}
}