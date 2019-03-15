package com.codingdojo.beltreviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.beltreviewer.models.Attend;
import com.codingdojo.beltreviewer.models.Event;
import com.codingdojo.beltreviewer.models.User;
import com.codingdojo.beltreviewer.services.EventService;
import com.codingdojo.beltreviewer.services.UserService;


@Controller
public class EventController {
	private final UserService uService;
	private final EventService eService;
	
	public EventController(UserService uService, EventService eService) {
		this.eService = eService;
		this.uService = uService;
	}
	
	// need to pass through users state to SQL query
	// need to change date format
	@RequestMapping("event/new")
	public String index(@ModelAttribute("eventObj") Event event, HttpSession session, Model model) {
		List<Object[]> events = eService.findESameState();
		model.addAttribute("e", events);
		List<Object[]> nonEvents = eService.findENotSameState();
		model.addAttribute("nonE", nonEvents);
		Long userId = (Long) session.getAttribute("userId"); // get user from session
    	User u = uService.findUserById(userId); // find the user
    	model.addAttribute("user", u); // save user in model
		return "pages/eventsPage.jsp";
	}
	// need to add future date validation
	@RequestMapping("/create/event")
	public String newEvent(@Valid @ModelAttribute("eventObj") Event event, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId"); // get user from session
	    	User u = uService.findUserById(userId); // find the user
	    	session.setAttribute("userId", u.getId()); // save their user id in session
	    	model.addAttribute("user", u); // save user in model
	    	return "pages/eventsPage.jsp";
		} else {
		Long userId = (Long) session.getAttribute("userId"); // get user from session
    	User u = uService.findUserById(userId); // find the user
    	session.setAttribute("userId", u.getId()); // save their user id in session
    	event.setUserId(u);
    	Event e = eService.createE(event);
		return "redirect:/events";
		}
	}
	
	// restrict so only creator can edit
	@RequestMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId"); // get user from session
		User u = uService.findUserById(userId); // find the user
		session.setAttribute("userId", u.getId()); // save their user id in session
		Event event = eService.findEvent(id);
		model.addAttribute("eventObj", event);
		return "/pages/editEvent.jsp";
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("eventObj") Event event, BindingResult result) {
		if (result.hasErrors()) {
			return "/pages/editEvent.jsp";
		} else {
			eService.createE(event);
			return "redirect:/events";
		}
	}
	
	@RequestMapping(value="/join/event/{id}")
	public String joinEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId"); // get user from session
		User u = uService.findUserById(userId); // find the user
		session.setAttribute("userId", u.getId()); // save their user id in session
		Event e = eService.findEvent(id); // find event
		List<Attend> attendees = u.getUsers();
		attendees.setUser(u);
		attendees.setEvent(e);
		return "pages/eventsPage.jsp";
	}
	
//	@RequestMapping("/events/{id}")
//	public String showEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
//		Long userId = (Long) session.getAttribute("userId"); // get user from session
//		User u = uService.findUserById(userId); // find the user
//		session.setAttribute("userId", u.getId()); // save their user id in session
//		Event event = eService.findEvent(id);
//		model.addAttribute("eventObj", event);
//		return "/pages/showEvent.jsp";
//	}
	
}
