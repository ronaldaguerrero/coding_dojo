package com.codingdojo.javabelt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.javabelt.models.Course;
import com.codingdojo.javabelt.models.Enroll;
import com.codingdojo.javabelt.repositories.CourseRepo;
import com.codingdojo.javabelt.repositories.EnrollRepo;
import com.codingdojo.javabelt.repositories.UserRepo;

@Service
public class DojoService {
	private final UserRepo uR;
	private final CourseRepo cR;
	private final EnrollRepo eR;
	
	public DojoService(UserRepo uR, CourseRepo cR, EnrollRepo eR) {
		this.uR = uR;
		this.cR = cR;
		this.eR = eR;
	}
	
	public List<Course> allCourses(){
		return cR.findAll();
	}

	public Long createCourse(Course course) {
		 return cR.save(course).getId();
	}

	public Course findCourse(Long id) {
		Optional<Course> optionalC = cR.findById(id);
		if(optionalC.isPresent()) {
			return optionalC.get();
		} else {
			return null;
		}
	}

	public void enroll(Enroll enroll) {
		 eR.save(enroll);
	}
	
	public List<Object[]>findEnrolledStudents(Long id){
		return eR.findAllStudentsEnrolled(id);
	}
	
	public Integer findNum(Long id) {
		return eR.findNumOfStudents(id);
	}

	public void deleteE(Long id) {
		 eR.deleteById(id);
	}
}
