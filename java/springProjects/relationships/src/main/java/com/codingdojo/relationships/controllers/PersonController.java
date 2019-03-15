package com.codingdojo.relationships.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class PersonController {
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public PersonController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/persons/new")
	public String index(@ModelAttribute("personObj") Person person) {
		return "/persons/newP.jsp";
	}
	
	@RequestMapping(value="create/person", method=RequestMethod.POST)
	public String newP(@Valid @ModelAttribute("personObj") Person person, BindingResult result, Model model) {
		if (result.hasErrors()){
			List<Person> persons = personService.allPersons();
			model.addAttribute("person", persons);
			return "/persons/new";
		} else {
			personService.createPerson(person);
			System.out.println("Person created...");
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping("/pDone")
	public String showP(Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons",persons);
		return "/persons/showP.jsp";
	}
	
	@RequestMapping("persons/{id}")
	public String show(@PathVariable("id") Long id, Model model){
		model.addAttribute("licenseObj", licenseService.getLicense(id).get());
		return "/persons/show.jsp";
	}
	
}
