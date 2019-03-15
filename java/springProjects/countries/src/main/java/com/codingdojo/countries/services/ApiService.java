package com.codingdojo.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.countries.repositories.CountryRepo;

@Service
public class ApiService {
	private final CountryRepo countryRepo;
	
	public ApiService(CountryRepo worldRepo) {
		this.countryRepo = worldRepo;
	}
	
	public List<Object[]> query() {
		return countryRepo.countOfCountriesByRegion();
	}
	
		
	
}
