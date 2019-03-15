package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepo;

@Service
public class LanguageService {
	
	private final LanguageRepo languageRepo;
	
	public LanguageService(LanguageRepo languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<Language> allLang() {
		return languageRepo.findAll();
	}
	
	public Language createLang(Language l) {
		return languageRepo.save(l);
	}
	
	public Language findLang(long id) {
		Optional<Language> optionalLang = languageRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}

	public void deleteLang(Long id) {
		languageRepo.deleteById(id);
	}
}
