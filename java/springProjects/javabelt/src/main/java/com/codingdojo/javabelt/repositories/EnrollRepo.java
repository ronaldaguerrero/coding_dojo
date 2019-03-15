package com.codingdojo.javabelt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javabelt.models.Enroll;

@Repository
public interface EnrollRepo extends CrudRepository<Enroll, Long>{

	@Query(value="SELECT javabelt.users.name, javabelt.enrollees.created_at, javabelt.enrollees.id FROM javabelt.enrollees LEFT JOIN javabelt.users ON javabelt.enrollees.user_id = javabelt.users.id WHERE javabelt.enrollees.course_id = ?1", nativeQuery=true)
	List<Object[]> findAllStudentsEnrolled(Long id);
	
	@Query(value="SELECT COUNT(javabelt.enrollees.user_id) FROM javabelt.enrollees WHERE javabelt.enrollees.course_id = ?1", nativeQuery=true)
	Integer findNumOfStudents(Long id);
}
