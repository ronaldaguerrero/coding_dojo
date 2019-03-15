package com.codingdojo.monopoly.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.monopoly.models.Property;

@Repository
public interface PropertyRepo extends CrudRepository<Property, Long>{
	List<Property> findAll();
}
