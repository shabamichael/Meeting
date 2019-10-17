package com.emergency.project;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@Entity @Table(name="Meetings") @ApiModel @ApiOperation(value = "Meeting POJO")
public class Meeting implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	@ApiModelProperty(notes = "The database generate unique primary key  ID")
	private long meetingId;
		
	@Temporal(TemporalType.DATE)@Column(name = "Date") @ApiModelProperty(notes = "The meeting date")
	private Date meetingDate;
	
	@Column(name = "Day") @ApiModelProperty(notes = "Day of the meeting ")
	private String meetingDay;
	
	@Column(name="Type")
	private String meetingType;
	
	@Column
	private int attendance;
	@Column
	private String soundOperator;
	private String attendant;
	@Column
	private String announcement;
	/*
	@Transient
	public GeneratedKeyHolder holder = new GeneratedKeyHolder();
	@Transient
	public long id =holder.getKey().longValue();
	*/
	public Meeting() {
		
	}
	
	public Meeting(long meetingId,  Date meetingDate, String meetingDay, String meetingType, int attendance,
			String soundOperator, String attendant, String announcement) {

		this.meetingId = meetingId;
		this.meetingDate = meetingDate;
		this.meetingDay = meetingDay;
		this.meetingType = meetingType;
		this.attendance = attendance;
		this.soundOperator = soundOperator;
		this.attendant = attendant;
		this.announcement = announcement;
	}

	

	public long getMeetingId() {
		return meetingId;
	}


	public void setMeetingId(long meetingId) {
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

	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", meetingDate=" + meetingDate + ", meetingDay=" + meetingDay
				+ ", meetingType=" + meetingType + ", attendance=" + attendance + ", soundOperator=" + soundOperator
				+ ", attendant=" + attendant + ", announcement=" + announcement + ", getMeetingId()=" + getMeetingId()
				+ ", getSoundOperator()=" + getSoundOperator() + ", getAttendant()=" + getAttendant()
				+ ", getAttendance()=" + getAttendance() + ", getMeetingType()=" + getMeetingType()
				+ ", getMeetingDate()=" + getMeetingDate() + ", getMeetingDay()=" + getMeetingDay()
				+ ", getAnnouncement()=" + getAnnouncement() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
