package com.emergency.project;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Meetings")
public class Meeting implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int meetingId;
	private String soundOperator;
	private String attendant;
	private int attendance;
	private String meetingType;
	private Date meetingDate;
	private String meetingDay;
	private String announcement;
	
	public Meeting() {
		
	}
	
	
	public Meeting(int meetingId, String soundOperator, String attendant, int attendance, String meetingType,
			Date meetingDate, String meetingDay, String announcement) {
		super();
		this.meetingId = meetingId;
		this.soundOperator = soundOperator;
		this.attendant = attendant;
		this.attendance = attendance;
		this.meetingType = meetingType;
		this.meetingDate = meetingDate;
		this.meetingDay = meetingDay;
		this.announcement = announcement;
	}


	public int getMeetingId() {
		return meetingId;
	}


	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}


	public String getSoundOperator() {
		return soundOperator;
	}


	public void setSoundOperator(String soundOperator) {
		this.soundOperator = soundOperator;
	}


	public String getAttendant() {
		return attendant;
	}


	public void setAttendant(String attendant) {
		this.attendant = attendant;
	}


	public int getAttendance() {
		return attendance;
	}


	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}


	public String getMeetingType() {
		MeetingLogic meetingLogic = new MeetingLogic() ;
		return meetingLogic.GetTypeOfMeeting(meetingType);
	}


	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}


	public Date getMeetingDate() {
		return meetingDate;
	}


	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}


	public String getMeetingDay() {
		return meetingDay;
	}


	public void setMeetingDay(String meetingDay) {
		this.meetingDay = meetingDay;
	}


	public String getAnnouncement() {
		return announcement;
	}


	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	
	

}
