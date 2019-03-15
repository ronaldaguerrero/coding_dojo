package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService langService;
	public LanguageController(LanguageService langService) {
		this.langService = langService;
	}
	
	
	
	@RequestMapping("/languages")
	public String index(Model model){
		List<Language> languages = langService.allLang();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@RequestMapping(value="/add/lang", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			langService.createLang(lang);
			System.out.println(lang);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLang(id);
		model.addAttribute("lang", lang);
		return "edit.jsp";
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			langService.createLang(lang);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		langService.deleteLang(id);
		return "redirect:/languages";
	}
	
}
