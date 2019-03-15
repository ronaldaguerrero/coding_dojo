package com.codingdojo.beltreviewer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.beltreviewer.models.Event;
import com.codingdojo.beltreviewer.models.User;
import com.codingdojo.beltreviewer.services.UserService;
import com.codingdojo.beltreviewer.validator.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
    
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user) {
        return "/pages/regPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
			return "/pages/regPage.jsp";
		} else {
			User u = userService.registerUser(user); // save the user in the DB
			session.setAttribute("userId", u.getId()); // save the userId in session
			return "redirect:/events";
		}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        boolean authenticated = userService.authenticateUser(email, password); // authentication check
        if(authenticated) { // if the user is authenticated
        	User u = userService.findByEmail(email); // find the email
        	session.setAttribute("userId", u.getId()); // save their user id in session
        	model.addAttribute("user", u); // save user in model
        	return "redirect:/event/new";
        } else {
        	model.addAttribute("error", "Invalid credentials. Try again.");
        	return "pages/regPage.jsp";
        }
    }

    @RequestMapping("/events")
    public String home(@ModelAttribute("eventObj") Event event, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("userId"); // get user from session
    	User u = userService.findUserById(userId); // find the user
    	model.addAttribute("user", u); // save user in model
    	return "/pages/eventsPage.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}