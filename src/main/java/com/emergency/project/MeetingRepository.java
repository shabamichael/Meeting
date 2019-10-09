package com.emergency.project;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
	List<Meeting>findAllByMeetingDate(Date meetingDate);
	List<Meeting>findAllByAttendant(String attendant);
	List<Meeting>findAllBySoundOperator(String soundOperator);
	List<Meeting>findAllByMeetingType(String meetingType);
	List<Meeting>findAllByMeetingDay(String meetingDay);
	

}
