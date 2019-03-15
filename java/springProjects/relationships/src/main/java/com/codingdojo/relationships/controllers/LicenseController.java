package com.codingdojo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	
	public LicenseController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("licenses/new")
	public String index(@ModelAttribute("licenseObj") License license, Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "licenses/newL.jsp";
	}
	
	@RequestMapping(value="create/license", method=RequestMethod.POST)
	public String newL(@RequestParam("pObj") Long p, @Valid @ModelAttribute("licenseObj") License license, BindingResult result, Model model) {
		if (result.hasErrors()){
			return "/licenses/newL.jsp";
		} else {
			Person person = personService.findPerson(p);
			String number = licenseService.generateLicenseNumber();
			license.setNumber(number);
			license.setPerson(person);
			licenseService.createLicense(license);
			System.out.println("License created...");
			return "redirect:/licenses/new";
		}
	}
}
