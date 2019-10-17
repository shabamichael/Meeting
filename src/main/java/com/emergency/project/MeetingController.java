package com.emergency.project;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping(MeetingController.BASE_URL)
public class MeetingController {
	private Logger logger =  LoggerFactory.getLogger(MeetingController.class);
	
	public static final String BASE_URL = "/api/v1";
	
	@Autowired
	public MeetingService meetingService;
	
	
	//Base or home for the meeting API
	@ApiOperation(value = "Base or home for the meeting API ", 
			notes = "This API does nothing. It is base or home for the meeting API",
			response = Meeting.class)
	@RequestMapping(method = RequestMethod.GET, value="/")
		public String Home() {
		String message = "<h3>WELCOME TO MEETINGS API</h3>";
		logger.trace("Response Status:- " + HttpStatus.OK +" Home method accessed");
		return message;
	}

	
	//Return all meetings in the database
	@ApiOperation(value = "Get all Meetings API ", 
			notes = "This API Return all meetings objects present in the database",
			response = Meeting.class)
	@RequestMapping(method=RequestMethod.GET, value = "/meetings")
	@GetMapping(value="/meetings")
	//public List <Meeting> getAllMeetings(){
		public Iterable <Meeting> getAllMeetings(){
		logger.trace("Response Status:- " + HttpStatus.OK +" Return all meetings in the database");
		return meetingService.findAllMeetings();
	}
	
	//Return all meetings in the database by date
	@ApiOperation(value = "Returns list of all meetings in the database by Meeting date ", 
			notes = "This API returns all meetings in the database by meeting date  present on the DB",
			response = Meeting.class)
	@RequestMapping(method = RequestMethod.GET, value="/date/{meetingDate}")
	public List<Meeting> getAllMeetingsByDate(@PathVariable Date meetingDate){
		logger.trace("Response Status:- " + HttpStatus.OK +" Return all meetings in the database by date");
		return meetingService.findAllMeetingsByDate(meetingDate);
	}
	
	//Return all meetings in the database by Attendant
	@ApiOperation(value = "Returns list of all meetings in the database by Attendant ", 
			notes = "This API returns all meetings in the database by Attendant  present on the DB",
			response = Meeting.class)
	@RequestMapping(method = RequestMethod.GET, value="/attendant/{attendant}")
	public List<Meeting> getAllMeetingsByAttendant(@PathVariable String attendant){
		logger.trace("Response Status:- " + HttpStatus.OK +" Return all meetings in the database by Attendant");
		return meetingService.findAllByAttendant(attendant);
	}
	
	//Return all meetings in the database by Sound Operator
	@ApiOperation(value = "Returns list of all meetings in the database by Sound Operator ", 
			notes = "This API returns all meetings in the database by Sound Operator  present on the DB",
			response = Meeting.class)
	@RequestMapping(method = RequestMethod.GET, value="/operator/{soundOperator}")
	public List <Meeting> getAllMeetingsBySoundOperator(@ PathVariable("soundOperator") String soundOperator){
		logger.trace("Response Status:- " + HttpStatus.OK +" Return all meetings in the database by Sound Operator");
		return meetingService.findAllBySoundOperator(soundOperator);
	}
	
	
	//Return all meetings in the database  by Meeting Type
	@ApiOperation(value = "Returns list of all meetings in the database by Meeting Type ", 
			notes = "This API returns all meetings in the database by Meeting Type  present on the DB",
			response = Meeting.class)
	@RequestMapping(method = RequestMethod.GET, value="/meetingtype/{type}")
	public List<Meeting> getAllMeetingsByMeetingsType(@PathVariable("type") String type){
		logger.trace("Response Status:- " + HttpStatus.OK +" Return all meetings in the database  by Meeting Type");
	return meetingService.findAllByMeetingType(type);
}
	
	//Return all meetings in the database by Meeting Day
	@ApiOperation(value = "Returns list of all meetings in the database by Meeting Day ", 
			notes = "This API returns all meetings in the database by Meeting Day  present on the DB",
			response = Meeting.class)
	@RequestMapping(method = RequestMethod.GET, value="/meetingday/{day}")
	public List<Meeting> getAllMeetingsByMeetingDay(@PathVariable("day") String day){
		logger.trace("Response Status:- " + HttpStatus.OK +" Return all meetings in the database by Meeting Day");
		return meetingService.findAllByMeetingDay(day);
	}
	
	//Return just one meeting by ID
	@ApiOperation(value = "Returns just one meeting by Id ", 
			notes = "This API returns a meeting object based on the Id if present on the DB",
			response = Meeting.class)
	@RequestMapping(method = RequestMethod.GET , value="/meeting/{Id}")
	public Meeting getMeeting(@PathVariable("Id") final long Id) {
		logger.trace("Response Status:- " + HttpStatus.OK +" Return just one meeting by ID. The meeting Id serached for is :- " + Id );
		return meetingService.FindOneMeetingById(Id);
	}
	
	//Return the total meeting count in the database
	@ApiOperation(value = "Counts the total number of meetings in the database", 
			notes = "This API returns the total number of meeting object  stored  in the database",
			response = Meeting.class)
	@RequestMapping(value="/count", method = RequestMethod.GET)
	@GetMapping( value= "/count")
	public String totalMeetingCount() {
		logger.trace("Response Status:- " + HttpStatus.OK +" Returns the total meeting count present on the database Total Count :- "
				+ meetingService.TotalNoOfMeetings());
	return "The total number of meeting(s) object in the database is "+ meetingService.TotalNoOfMeetings();
	}
	
	//Save a new meeting
	@ApiOperation(value = "Create or add a meetings object API ", 
			notes = "This API creates a new meetings object and stores it in the database",
			response = Meeting.class)
	@RequestMapping(method=RequestMethod.POST, value="/save")
	@PostMapping(value="/save")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveMeeting(@RequestBody Meeting meeting) {
		logger.trace("Response Status:- "+HttpStatus.CREATED + ". A new meeting object has been successfully created..."  );
		meetingService.saveMeeting(meeting);
	}
	
	//Update an existing meeting
	@ApiOperation(value = "Updates an existing meetings object API ", 
			notes = "This API updates an existing  meetings object and stores it in the database",
			response = Meeting.class)
	@RequestMapping(method = RequestMethod.PUT, value="/update/{Id}")
	@PutMapping(value="/update/{Id}")
	public Object updateMeeting(@PathVariable long Id, @RequestBody Meeting meeting) {
		meetingService.UpdateMeeting(Id, meeting);
		logger.trace("Response Status:- " + HttpStatus.ACCEPTED + " Successfully updated an existing meeting Id No"+ Id + "...");
		meetingService.UpdateMeeting(Id, meeting);
		meetingService.deleteMeeting(Id);
		return "Meeting id " + Id + " has been updated\n" + meeting;
	}
	
	
	//Delete an existing meeting from the database
	@ApiOperation(value = "Deletes an existing meetings object  from the database ", 
			notes = "This API deletes an existing  meetings object from the database",
			response = Meeting.class)
	@DeleteMapping(value="/delete/{Id}")
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{Id}")
	public Object deleteMeeting(@PathVariable long Id) {
		logger.trace("Response Status:- " + HttpStatus.OK + " Successfully deleted an existing meeting Id No "+ Id + "...");
		meetingService.deleteMeeting(Id);
		return   "Meeting Id " +Id + " has been deleted";
		
	}
	

	
	
}
