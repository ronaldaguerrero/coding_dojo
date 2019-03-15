package com.codingdojo.dojo_ninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojo_ninja.models.Dojo;
import com.codingdojo.dojo_ninja.repositories.DojoRepo;

@Service
public class DojoService {

	private final DojoRepo dojoRepo;
	
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}

	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}

	public Dojo findDojo(long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			System.out.println("not found");
			return null;
		}
	}
	
	
}
