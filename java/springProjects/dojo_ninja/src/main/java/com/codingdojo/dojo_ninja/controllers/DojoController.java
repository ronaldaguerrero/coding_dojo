package com.codingdojo.dojo_ninja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojo_ninja.models.Dojo;
import com.codingdojo.dojo_ninja.services.DojoService;
import com.codingdojo.dojo_ninja.services.NinjaService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("dojos/new")
	public String index(@ModelAttribute("dojoObj") Dojo dojo) {
		return "/dojo_ninja/index.jsp";
	}
	
	@RequestMapping(value="create/dojo", method=RequestMethod.POST)
	public String newDojo(@ModelAttribute("dojoObj") Dojo dojo, Model model) {
		dojoService.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojo_ninja/show.jsp";
	}
	
}
