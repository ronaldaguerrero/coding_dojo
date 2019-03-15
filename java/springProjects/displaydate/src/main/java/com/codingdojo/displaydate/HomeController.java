package com.codingdojo.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		String date = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMMM, yyyy").format(new Date());
	    model.addAttribute("date", date);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		String time = new SimpleDateFormat("hh:mm aa").format(new Date());
	    model.addAttribute("time", time);
		return "time.jsp";
	}
}
