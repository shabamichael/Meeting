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
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

@Autowired
private MeetingRepository meetingRepo;




public Iterable<Meeting> findAllMeetings() {
	List<Meeting> meetings = new ArrayList<Meeting>();
	meetingRepo.findAll().forEach(meetings::add);
	return meetings ;
}

	
	public List<Meeting> findAllMeetingsByDate(Date meetingDate){
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllByMeetingDate(meetingDate).forEach(meetings::add);
		return meetings;
		}
		
	public List<Meeting>findAllByAttendant(String attendant){
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllByAttendant(attendant).forEach(meetings::add);
		return meetings;
	}
	
	public List<Meeting>findAllBySoundOperator(String soundOperator){
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllBySoundOperator(soundOperator).forEach(meetings::add);
		return meetings;
	}
	public List<Meeting>findAllByMeetingType(String meetingType){
		List <Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllByMeetingType(meetingType).forEach(meetings::add);
		return meetings;
	}
	public List<Meeting>findAllByMeetingDay(String meetingDay){
		List <Meeting> meetings = new ArrayList<Meeting>();
		meetingRepo.findAllByMeetingDay(meetingDay).forEach(meetings::add);
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
