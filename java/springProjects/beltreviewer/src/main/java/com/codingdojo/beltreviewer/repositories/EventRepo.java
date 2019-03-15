package com.codingdojo.beltreviewer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltreviewer.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long>{
	// need to pass parameters through
	@Query(value="SELECT javabeltreviewer.events.id, javabeltreviewer.events.name, javabeltreviewer.events.date, javabeltreviewer.events.city, javabeltreviewer.users.f_name FROM javabeltreviewer.users LEFT JOIN javabeltreviewer.events on users.id = events.user_id WHERE javabeltreviewer.events.state='CA';", nativeQuery=true)
	List<Object[]> findAllEventsWhereStateAreSame();
	
	@Query(value="SELECT javabeltreviewer.events.id, javabeltreviewer.events.name, javabeltreviewer.events.date, javabeltreviewer.events.city, javabeltreviewer.users.f_name FROM javabeltreviewer.users LEFT JOIN javabeltreviewer.events on users.id = events.user_id WHERE javabeltreviewer.events.state!='CA';", nativeQuery=true)
	List<Object[]> findAllEventsWhereStateAreNotSame();
	
	//need to specify user_id and event_id
//	@Query(value="DELETE FROM javabeltreviewer.attending WHERE ID = 1;",nativeQuery=true)
//	Event removeAttendee();
//	
//	@Query(value="INSERT INTO javabeltreviewer.messages (event_id, user_id, message) VALUES ('13','1','hello');", nativeQuery=true)
//	List<Object[]> createMessage();
//	
//	@Query(value="SELECT javabeltreviewer.users.f_name FROM javabeltreviewer.attending LEFT JOIN javabeltreviewer.users ON users.id = attending.user_id WHERE javabeltreviewer.attending.event_id = '13';", nativeQuery=true)
//	List<Object[]> showAttendees();	
//	
//	@Query(value="SELECT COUNT(javabeltreviewer.users.id) FROM javabeltreviewer.attending LEFT JOIN javabeltreviewer.users ON users.id = attending.user_id WHERE javabeltreviewer.attending.event_id = '13';", nativeQuery=true)
//	Integer showAttendeeCount();
}



// create a message query with event's event id and user id
// INSERT INTO javabeltreviewer.messages (event_id, user_id, message) VALUES ('13','1','hello');


// create a attendees query where event id = 'x' and show all members
// SELECT javabeltreviewer.users.f_name FROM javabeltreviewer.attending LEFT JOIN javabeltreviewer.users ON users.id = attending.user_id WHERE javabeltreviewer.attending.event_id = '13';

// can the info from these two ^v come from the same query
// create an event query to display event info events.date, events.city, events.location count of people attending.