package com.emergency.project;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
	
	List<Meeting>findAllByMeetingDate(Date meetingDate, Pageable pageable);
	List<Meeting>findAllByMeetingType(String meetingType, Pageable pageable);
	List<Meeting>findAllByMeetingDay(String meetingDay, Pageable pageable);
	List<Meeting>findAllByAttendantFirstName(String attendantFirstName, Pageable pageable);
	List<Meeting>findAllByAttendantLastName(String attendantLastName, Pageable pageable);

	List<Meeting>findAllBySoundOperatorFirstName(String soundOperatorFirstName, Pageable pageable);
	List<Meeting>findAllBySoundOperatorLastName(String soundOperatorLastName, Pageable pageable);

	}
