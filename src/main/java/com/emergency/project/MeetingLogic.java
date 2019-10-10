package com.emergency.project;

import java.time.format.DateTimeFormatter;

public class MeetingLogic {
	public String WEEKEND = "WEEKEND MEETING";
	public String MIDWEEK = "MIDWEEK MEETING";
	
	public String GetTypeOfMeeting(String meetingType) {
		
	if (meetingType.equalsIgnoreCase("WEEKEND")) {
			meetingType = WEEKEND;			
		}
	else if(meetingType.equalsIgnoreCase("MIDWEEK")) {
			meetingType = MIDWEEK;
	}
	else {
		meetingType = "INVALID MEETING TYPE";
	}
	return meetingType;
	}

	
}
