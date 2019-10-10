package com.emergency.project;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MeetingController.BASE_URL)
public class MeetingController {
	public static final String BASE_URL = "/api/v1";
	@Autowired
	public MeetingService meetingService;
	
	@RequestMapping(method = RequestMethod.GET, value="")
	public String Home() {
		String message = "<h3>WELCOME TO MEETINGS API</h3>";
		return message;
	}

	
	//Return all meetings in the database
	@RequestMapping(method = RequestMethod.GET, value="/meetings")
	public List <Meeting> getAllMeetings(){
		return meetingService.findAllMeetings();
	}
	
	//Return all meetings in the database by date
	@RequestMapping(method = RequestMethod.GET, value="/meetingsdate/{meetingDate}")
	public List<Meeting> getAllMeetingsByDate(@PathVariable Date meetingDate){
		return meetingService.findAllMeetingsByDate(meetingDate);
	}
	
	//Return all meetings in the database by Attendant
	@RequestMapping(method = RequestMethod.GET, value="/meetingsatt/{attendant}")
	public List<Meeting> getAllMeetingsByAttendant(@PathVariable String attendant){
		return meetingService.findAllByAttendant(attendant);
	}
	
	//Return all meetings in the database by Sound Operator
	@RequestMapping(method = RequestMethod.GET, value="/meetingsso/{soundOperator")
	public List <Meeting> getAllMeetingsBySoundOperator(@ PathVariable String soundOperator){
		return meetingService.findAllBySoundOperator(soundOperator);
	}
	
	
	//Return all meetings in the database  by Meeting Type
	@RequestMapping(method = RequestMethod.GET, value="/meetingstype/{meetingType}")
	public List<Meeting> getAllMeetingsByMeetingsType(@PathVariable String meetingType){
	return meetingService.findAllByMeetingType(meetingType);
}
	
	//Return all meetings in the database by Meeting Day
	@RequestMapping(method = RequestMethod.GET, value="/meetingsday/{meetingDay")
	public List<Meeting> getAllMeetingsByMeetingDay(@PathVariable String meetingDay){
		return meetingService.findAllByMeetingDay(meetingDay);
	}
	
	//Return just one meeting by ID
	@RequestMapping(method = RequestMethod.GET , value="/meeting/{id}")
	public Meeting getMeeting(@PathVariable long Id) {
		return meetingService.FindOneMeetingById(Id);
	}
	
	//Return the total meeting count
	@RequestMapping(method = RequestMethod.GET, value= "/meeting/count")
	public int totalMeetingCount() {
	return meetingService.TotalNoOfMeetings();
	}
	
	//Save a new meeting
	@RequestMapping(method= RequestMethod.POST, value="/meeting")
	public void saveMeeting(@RequestBody Meeting meeting) {
		meetingService.saveMeeting(meeting);
	}
	
	//Delete a meeting
	@RequestMapping(method = RequestMethod.DELETE, value="/meeting/{Id}")
	public Object deleteMeeting(@PathVariable long Id) {
		meetingService.deleteMeeting(Id);
		return   "Meeting Id " +Id + " Deleted";
		
	}
	
	//Update an existing meeting
	@RequestMapping(method = RequestMethod.PUT, value="/meeting/{Id}")
	public Object updateMeeting(@PathVariable long Id, @RequestBody Meeting meeting) {
		meetingService.UpdateMeeting(Id, meeting);
		return "Meeting " + Id + "has been updated to\n" + meeting;
	}
	
	
}
