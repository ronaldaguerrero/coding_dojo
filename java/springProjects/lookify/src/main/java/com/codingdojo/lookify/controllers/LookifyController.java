package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookService;
	
	public LookifyController(LookifyService lookService) {
		this.lookService = lookService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "/lookify/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String index(Model model) {
		List<Lookify> looks = lookService.allLooks();
		model.addAttribute("looks", looks);
		return "/lookify/dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newLook(@ModelAttribute("looks") Lookify look) {
		return "lookify/new.jsp";
	}
	
	@RequestMapping(value="/add/song", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("looks") Lookify look, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Lookify> looks = lookService.allLooks();
    		model.addAttribute("looksObj", looks);
			return "/lookify/new.jsp";
		} else {
			lookService.createLook(look);
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/search")
	public String search(@RequestParam("artist") String artist) {
		return "redirect:/search/"+artist;
	}
	
	@RequestMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist, Model model){
		List <Lookify> songs = lookService.getSearch(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songs);
		return "/lookify/search.jsp";
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model){
		Lookify look = lookService.findLook(id);
		model.addAttribute("lookObj", look);
		return "/lookify/show.jsp";
	}
	
	@RequestMapping(value="delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		lookService.deleteLook(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="search/topTen")
	public String topTen(@ModelAttribute("looks") Lookify look, Model model) {
		List <Lookify> looks = lookService.getTop();
		model.addAttribute("top", looks);
		return "/lookify/topten.jsp";
	}
	
	
	
	
}
