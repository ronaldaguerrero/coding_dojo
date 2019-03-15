package com.codingdojo.dojo_ninja.services;

import org.springframework.stereotype.Service;

import com.codingdojo.dojo_ninja.models.Ninja;
import com.codingdojo.dojo_ninja.repositories.NinjaRepo;

@Service
public class NinjaService {

private final NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
}
