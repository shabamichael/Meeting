package com.emergency.project;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MeetingLogic {
	public String WEEKEND = "WEEKEND MEETING";
	public String MIDWEEK = "MIDWEEK MEETING";
	
	public String GetTypeOfMeeting(String meetingType) {
		
	if (meetingType.equalsIgnoreCase("WEEKEND") || (meetingType.equalsIgnoreCase("WEEKEND MEETING"))) {
			meetingType = WEEKEND;			
		}
	else if(meetingType.equalsIgnoreCase("MIDWEEK") || (meetingType.equalsIgnoreCase("MIDWEEK MEETING"))) {
			meetingType = MIDWEEK;
	}
	else {
		meetingType = "INVALID MEETING TYPE";
	}
	return meetingType;
	}
	
	public String currentDate() {
		return new Date().toString();
		
	}
	
	
	

}