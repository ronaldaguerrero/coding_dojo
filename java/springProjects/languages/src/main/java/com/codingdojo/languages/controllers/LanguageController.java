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
	public String index(@ModelAttribute("langObj") Language lang, Model model) {
		List<Language> languages = langService.allLang();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	@RequestMapping("/lang/new")
    public String newLang(@ModelAttribute("langObj") Language lang) {
        return "/languages/new.jsp";
    }
	
	@RequestMapping(value="/add/lang", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("langObj") Language lang, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Language> languages = langService.allLang();
    		model.addAttribute("languages", languages);
			return "/languages/index.jsp";
		} else {
			langService.createLang(lang);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLang(id);
		model.addAttribute("langObj", lang);
		return "/languages/edit.jsp";
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("langObj") Language lang, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/index.jsp";
		} else {
			langService.createLang(lang);
			return "redirect:/languages";
		}
	}

	@RequestMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Language lang = langService.findLang(id);
        model.addAttribute("langObj", lang);
        return "/languages/show.jsp";
    }
	
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		langService.deleteLang(id);
		return "redirect:/languages";
	}
}
