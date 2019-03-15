package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Lookify;

@Repository
public interface LookifyRepo extends CrudRepository<Lookify, Long>{
	// this method retrieves all the books from the database
    List<Lookify> findAll();
    // this method find a book by their description
    List<Lookify> findByTitleContaining(String search);
	List<Lookify> findByArtist(String artist);
	List<Lookify> findTop10ByOrderByRatingDesc();
}

