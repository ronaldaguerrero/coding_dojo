package com.codingdojo.javabelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javabelt.models.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long>{
	List<Course> findAll();
}
