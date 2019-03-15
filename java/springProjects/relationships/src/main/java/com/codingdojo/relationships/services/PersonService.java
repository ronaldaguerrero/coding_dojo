package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepo;

@Service
public class PersonService {
	
	private final PersonRepo personRepo;
	
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	public Person createPerson (Person p) {
		return personRepo.save(p);
	}

	public List<Person> allPersons() {
		return personRepo.findAll();
	}

	public Person findPerson(long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			System.out.println("found");
			System.out.println(optionalPerson.get());
			return optionalPerson.get();
		} else {
			System.out.println("not found");
			return null;
		}
	}
	
	
}
