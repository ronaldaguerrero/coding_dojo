package com.codingdojo.countries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.countries.services.ApiService;

@RestController
public class WorldController {
	private final ApiService apiService;
	
	public WorldController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public List<Object[]> index() {
		return apiService.query();
	}
}
