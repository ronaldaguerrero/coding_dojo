package com.codingdojo.beltreviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.beltreviewer.models.Event;
import com.codingdojo.beltreviewer.repositories.EventRepo;
import com.codingdojo.beltreviewer.repositories.UserRepo;

@Service
public class EventService {
	private final EventRepo eRepo;
	private final UserRepo  uRepo;
	
	public EventService(EventRepo eRepo, UserRepo uRepo) {
		this.eRepo = eRepo;
		this.uRepo = uRepo;
	}
	
	public Event createE(Event e) {
		 return eRepo.save(e);
	}
	
	public List<Object[]> findESameState(){
		return eRepo.findAllEventsWhereStateAreSame();
	}
	
	public List<Object[]> findENotSameState(){
		return eRepo.findAllEventsWhereStateAreNotSame();
	}
	
//	public Event removeAttendee(){
//		return eRepo.removeAttendee();
//	}
//	
//	public List<Object[]> createMessage(){
//		return eRepo.createMessage();
//	}
//	
//	public List<Object[]> showAttendees(){
//		return eRepo.showAttendees();
//	}
//	
//	public Integer showAttendeeCount() {
//		return eRepo.showAttendeeCount();
//	}

	public Event findEvent(Long id) {
		Optional<Event> optionalE = eRepo.findById(id);
		if(optionalE.isPresent()) {
			return optionalE.get();
		} else {
			return null;
		}
	}

}
