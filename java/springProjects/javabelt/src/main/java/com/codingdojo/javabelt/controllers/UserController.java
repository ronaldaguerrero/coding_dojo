package com.codingdojo.javabelt.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.javabelt.models.Course;
import com.codingdojo.javabelt.models.User;
import com.codingdojo.javabelt.services.DojoService;
import com.codingdojo.javabelt.services.UserService;
import com.codingdojo.javabelt.validator.UserValidator;


@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final DojoService dS;
    
    public UserController(UserService userService, UserValidator userValidator, DojoService dS) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.dS = dS;
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
			return "redirect:/courses";
		}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("user") User user) {
        boolean authenticated = userService.authenticateUser(email, password); // authentication check
        if(authenticated) { // if the user is authenticated
        	User u = userService.findByEmail(email); // find the email
        	session.setAttribute("userId", u.getId()); // save their user id in session
        	return "redirect:/courses";
        } else {
        	model.addAttribute("error", "Invalid credentials. Try again.");
        	return "pages/regPage.jsp";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}
