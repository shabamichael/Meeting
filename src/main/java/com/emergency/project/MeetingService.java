package com.emergency.project;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

@Autowired
private MeetingRepository meetingRepo;




public List<Meeting> findAllMeetings() {
	List<Meeting> meetings = new ArrayList<Meeting>();
	meetingRepo.findAll().forEach(meetings::add);
	return meetings ;
}

	
	public List<Meeting> findAllMeetingsByDate(Date meetingDate, PageRequest pageRequest){
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllByMeetingDate(meetingDate, pageRequest).forEach(meetings::add);
		return meetings;
		}
		
	public List<Meeting>findAllByAttendantLastName(String attendantLastName, PageRequest pageRequest){
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllByAttendantLastName(attendantLastName, pageRequest).forEach(meetings::add);
		return meetings;
	}
	public List<Meeting>findAllByAttendantFirstName(String attendantFirstName, PageRequest pageRequest){
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllByAttendantFirstName(attendantFirstName, pageRequest).forEach(meetings::add);;
		return meetings;
	}
	
	
	public List<Meeting>findAllBySoundOperatorLastName(String soundOperatorLastName, PageRequest pageRequest){
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllBySoundOperatorLastName(soundOperatorLastName, pageRequest).forEach(meetings::add);
		return meetings;
	}
	
	
	public List<Meeting>findAllBySoundOperatorFirstName(String soundOperatorFirstName, PageRequest pageRequest){
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllBySoundOperatorLastName(soundOperatorFirstName, pageRequest).forEach(meetings::add);
		return meetings;
	}
	
	
	public List<Meeting>findAllByMeetingType(String meetingType, PageRequest pageRequest){
		List <Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllByMeetingType(meetingType, pageRequest).forEach(meetings::add);
		return meetings;
	}
	
	 
	public List<Meeting>findAllByMeetingDay(String meetingDay, PageRequest pageRequest){
		List <Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllByMeetingDay(meetingDay, pageRequest).forEach(meetings::add);
		return meetings;
	}
	
	public void saveMeeting(Meeting meeting) {
		meetingRepo.save(meeting);
	}
	
	public void deleteMeeting(long Id) {
		meetingRepo.deleteById(Id);
	}
	
	public int TotalNoOfMeetings() {
		return (int) meetingRepo.count();
	}
	
	public Meeting FindOneMeetingById(long Id) {
		Meeting meeting = new Meeting();
		meeting = meetingRepo.findById(Id).get();
		return meeting;
	}
	
	public Meeting UpdateMeeting(long Id, Meeting meeting) {
		
		meetingRepo.save(meeting);
		return meeting;
	}
	
	
}
