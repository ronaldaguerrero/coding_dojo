package com.codingdojo.ninjagold.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(HttpSession session) {
		if (session.isNew()) {
			Integer goldVal = 0;
			session.setAttribute("gold", goldVal);
			ArrayList<String> act = new ArrayList<String>();
			session.setAttribute("activities", act);
			Integer gold = (Integer) session.getAttribute("gold");
		} if (session.getAttribute("activities") == null){
			ArrayList<String> act = new ArrayList<String>();
			session.setAttribute("activities", act);
		} else {
			Integer gold = (Integer) session.getAttribute("gold");
			
			
		}
		return "home.jsp";
	}
	
	@PostMapping("/process_money")
	public String process_money(@RequestParam(value="type") String loc, HttpSession session) {
		session.setAttribute("loc", loc);
		Random rand = new Random();
		String date = new SimpleDateFormat("MMMMM dd, yyyy hh:mm aa").format(new Date());
		if (loc.equals("farm")) {
			System.out.println("executing farm...");
			int n = rand.nextInt((20 - 10)+1) + 10;
			System.out.println("Random num is: " + n);
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", gold+=n);
			
			String newact = "Earned " + n + " gold at the farm at " + date;
			ArrayList<String> acts = (ArrayList<String>) session.getAttribute("activities");
			acts.add(newact);
			session.setAttribute("activities", acts);
			
		} else if (loc.equals("cave")){
			System.out.println("executing cave...");
			int n = rand.nextInt((10 - 5)+1) + 5;
			System.out.println("Random num is: " + n);
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", gold+=n);
			
			String newact = "Earned " + n + " gold at the cave at " + date;
			ArrayList<String> acts = (ArrayList<String>) session.getAttribute("activities");
			acts.add(newact);
			session.setAttribute("activities", acts);
		} else if (loc.equals("house")){
			System.out.println("executing house...");
			int n = rand.nextInt((5 - 2)+1) + 2;
			System.out.println("Random num is: " + n);
			
			String newact = "Earned " + n + " gold at the house at " + date;
			ArrayList<String> acts = (ArrayList<String>) session.getAttribute("activities");
			acts.add(newact);
			session.setAttribute("activities", acts);
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", gold+=n);
		} else if (loc.equals("casino")){
			System.out.println("executing casino...");
			int n = ThreadLocalRandom.current().nextInt(-50,50);
			System.out.println("Random num is: " + n);
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", gold+=n);
			
			if (n > 0) {
				String newact = "Earned " + n + " gold at the casino at " + date;
				ArrayList<String> acts = (ArrayList<String>) session.getAttribute("activities");
				acts.add(newact);
				session.setAttribute("activities", acts);
			} else {
				String newact = "Lost " + (n * -1) + " at the casino at " + date;
				ArrayList<String> acts = (ArrayList<String>) session.getAttribute("activities");
				acts.add(newact);
				session.setAttribute("activities", acts);
			}
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold");
		session.setAttribute("gold", 0);
		session.setAttribute("activities", null);
		return "redirect:/";
	}
}
	

