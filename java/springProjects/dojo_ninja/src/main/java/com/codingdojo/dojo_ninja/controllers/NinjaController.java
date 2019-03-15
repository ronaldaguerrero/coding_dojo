package com.codingdojo.dojo_ninja.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojo_ninja.models.Dojo;
import com.codingdojo.dojo_ninja.models.Ninja;
import com.codingdojo.dojo_ninja.services.DojoService;
import com.codingdojo.dojo_ninja.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@RequestMapping("ninjas/new")
	public String index(@ModelAttribute("ninjaObj") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "dojo_ninja/ninja.jsp";
	}
	
	@RequestMapping(value="create/ninja", method=RequestMethod.POST)
	public String newDojo(@RequestParam("dojo") long d, @ModelAttribute("ninjaObj") Ninja ninja, Model model) {
		Dojo dojo = dojoService.findDojo(d);
		ninja.setDojo(dojo);
		ninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
	
}
