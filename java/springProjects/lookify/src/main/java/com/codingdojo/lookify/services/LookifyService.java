package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.repositories.LookifyRepo;

@Service
public class LookifyService {

	private final LookifyRepo lookifyRepo;
	
	public LookifyService(LookifyRepo lookifyRepo) {
		this.lookifyRepo = lookifyRepo;
	}
	
	public List<Lookify> allLooks(){
		return lookifyRepo.findAll();
	}
	
	public Lookify createLook(Lookify l) {
		return lookifyRepo.save(l);
	}
	
	public Lookify findLook(long id) {
		Optional<Lookify> optionalLook = lookifyRepo.findById(id);
		if(optionalLook.isPresent()) {
			return optionalLook.get();
		} else {
			return null;
		}
	}
	
	public void deleteLook(Long id) {
		lookifyRepo.deleteById(id);
	}

	public List<Lookify> getSearch(String artist){
		return lookifyRepo.findByArtist(artist);
	}
	
	public List<Lookify> getTop(){
		return lookifyRepo.findTop10ByOrderByRatingDesc();
	}
}
