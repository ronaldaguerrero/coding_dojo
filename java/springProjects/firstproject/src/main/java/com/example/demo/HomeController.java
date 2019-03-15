package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HomeController {
//	@RequestMapping("/")
//	public String hello() { // 3
//		return "Hello World!";
//	}
//	
//	@RequestMapping("/world")
//	public String world() { // 3
//		return "Class level annotations are cool too!";
//	}
	
	@RequestMapping("")
	public String index() {
		return "Hello user!";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String helloW() {
		return "Hello World! What route did you use to access me?";
	}
	
	@RequestMapping("/goodbye")
	public String worldT() {
		return "Goodbye world!";
	}
	
	@RequestMapping("/param")
	public String param(@RequestParam(value="p", required=false) String searchQuery) {
		return "Your searched for: " + searchQuery;
	}
	
	@RequestMapping("/p/{track}/{module}/{lesson}")
	public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable ("lesson") String lesson) {
		return "Track " + track + "Module : " + module + ", Lesson: " + lesson;
	}
}

