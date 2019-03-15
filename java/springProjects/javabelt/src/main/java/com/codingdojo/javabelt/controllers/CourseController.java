package com.codingdojo.javabelt.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.javabelt.models.Course;
import com.codingdojo.javabelt.models.Enroll;
import com.codingdojo.javabelt.models.User;
import com.codingdojo.javabelt.services.DojoService;
import com.codingdojo.javabelt.services.UserService;

@Controller
public class CourseController {
	private final UserService userService;
	private final DojoService dS;
    
    public CourseController(UserService userService, DojoService dS) {
        this.userService = userService;
        this.dS = dS;
    }
    
    @RequestMapping("/courses")
    public String home(@ModelAttribute("enrollObj") Enroll enroll, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("userId"); // get user from session
    	User u = userService.findUserById(userId); // find the user
    	model.addAttribute("user", u); // save user in model
    	List<Course> courses = dS.allCourses();
    	model.addAttribute("courses", courses);
    	return "/pages/dashboard.jsp";
    }
    
    @RequestMapping("courses/new")
    public String newCourse(@ModelAttribute("courseObj") Course course, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("userId"); // get user from session
    	User u = userService.findUserById(userId); // find the user
    	return "pages/newCourse.jsp";
    }
    
    @PostMapping("/create/course")
    public String create(@Valid @ModelAttribute("courseObj") Course course, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Course> courses = dS.allCourses();
			model.addAttribute("courses", courses);
			return "/pages/newCourse.jsp";
		} else {
			dS.createCourse(course);
			return "redirect:/courses";
		}
	}
    
    @RequestMapping("/courses/{id}")
    public String show(@PathVariable("id")Long id, Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId"); // get user from session
    	User u = userService.findUserById(userId); // find the user
    	Course course = dS.findCourse(id);
    	model.addAttribute("courseObj", course);
    	List<Object[]> eS = dS.findEnrolledStudents(id);
    	model.addAttribute("e", eS);
    	Integer num = dS.findNum(id);
    	model.addAttribute("num", num);
    	return "pages/showCourse.jsp";
    }
    
    @RequestMapping("/courses/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId"); // get user from session
    	User u = userService.findUserById(userId); // find the user
    	Course course = dS.findCourse(id);
    	model.addAttribute("courseObj", course);
    	return "/pages/editCourse.jsp";
    }
    
    @RequestMapping(value="update/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("courseObj") Course course, BindingResult result) {
		if (result.hasErrors()) {
			// redirect to same page and display errors
			return "/pages/editCourse.jsp";
		} else {
			dS.createCourse(course);
			return "redirect:/courses";
		}
	}
    
    @PostMapping(value="enroll")
    public String enroll(@ModelAttribute("enrollObj") Enroll enroll) {
    	dS.enroll(enroll);
    	return "redirect:/courses";
    }
    
//    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
//    public String remove(@PathVariable("id") Long id) {
//    	dS.deleteE(id);
//    	return "redirect:/courses" + id.get;
//    }
}
