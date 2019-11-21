package com.emergency.project;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@Entity 
@Table(name="Meetings") 
@ApiModel 
@ApiOperation(value = "Meeting POJO")
@DynamicUpdate

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
	
	@Column(name="Attendance")
	private int attendance;
	
	@Column(name="SoundOPeratorName")
	private String soundOperatorFirstName;
	
	@Column(name ="SoundOPeratorSurname")
	private String soundOperatorLastName;
	
	@Column(name = "AttendantName")
	private String attendantFirstName;
	
	@Column(name= "AttendantSurname")
	private String attendantLastName;
	
	@Column(name="Announcement")
	private String announcement;
	
	@Transient
	private String emailTo;
	
	public Meeting() {
		
	}
	
	

	

	public Meeting(long meetingId, Date meetingDate, String meetingDay, String meetingType, int attendance,
			String soundOperatorFirstName, String soundOperatorLastName, String attendantFirstName,
			String attendantLastName, String announcement, String emailTo) {
		super();
		this.meetingId = meetingId;
		this.meetingDate = meetingDate;
		this.meetingDay = meetingDay;
		this.meetingType = meetingType;
		this.attendance = attendance;
		this.soundOperatorFirstName = soundOperatorFirstName;
		this.soundOperatorLastName = soundOperatorLastName;
		this.attendantFirstName = attendantFirstName;
		this.attendantLastName = attendantLastName;
		this.announcement = announcement;
		this.emailTo = emailTo;
	}





	/**
	 * @return the meetingId
	 */
	public long getMeetingId() {
		return meetingId;
	}





	/**
	 * @param meetingId the meetingId to set
	 */
	public void setMeetingId(long meetingId) {
		this.meetingId = meetingId;
	}





	/**
	 * @return the meetingDate
	 */
	public Date getMeetingDate() {
		return meetingDate;
	}





	/**
	 * @param meetingDate the meetingDate to set
	 */
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}





	/**
	 * @return the meetingDay
	 */
	public String getMeetingDay() {
		return meetingDay;
	}





	/**
	 * @param meetingDay the meetingDay to set
	 */
	public void setMeetingDay(String meetingDay) {
		this.meetingDay = meetingDay;
	}





	/**
	 * @return the meetingType
	 */
	public String getMeetingType() {
		return meetingType;
	}





	/**
	 * @param meetingType the meetingType to set
	 */
	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}





	/**
	 * @return the attendance
	 */
	public int getAttendance() {
		return attendance;
	}





	/**
	 * @param attendance the attendance to set
	 */
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}





	/**
	 * @return the soundOperatorFirstName
	 */
	public String getSoundOperatorFirstName() {
		return soundOperatorFirstName;
	}





	/**
	 * @param soundOperatorFirstName the soundOperatorFirstName to set
	 */
	public void setSoundOperatorFirstName(String soundOperatorFirstName) {
		this.soundOperatorFirstName = soundOperatorFirstName;
	}





	/**
	 * @return the soundOperatorLastName
	 */
	public String getSoundOperatorLastName() {
		return soundOperatorLastName;
	}





	/**
	 * @param soundOperatorLastName the soundOperatorLastName to set
	 */
	public void setSoundOperatorLastName(String soundOperatorLastName) {
		this.soundOperatorLastName = soundOperatorLastName;
	}





	/**
	 * @return the attendantFirstName
	 */
	public String getAttendantFirstName() {
		return attendantFirstName;
	}





	/**
	 * @param attendantFirstName the attendantFirstName to set
	 */
	public void setAttendantFirstName(String attendantFirstName) {
		this.attendantFirstName = attendantFirstName;
	}





	/**
	 * @return the attendantLastName
	 */
	public String getAttendantLastName() {
		return attendantLastName;
	}





	/**
	 * @param attendantLastName the attendantLastName to set
	 */
	public void setAttendantLastName(String attendantLastName) {
		this.attendantLastName = attendantLastName;
	}





	/**
	 * @return the announcement
	 */
	public String getAnnouncement() {
		return announcement;
	}



	/**
	 * @param announcement the announcement to set
	 */
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}





	/**
	 * @return the emailTo
	 */
	public String getEmailTo() {
		return emailTo;
	}





	/**
	 * @param emailTo the emailTo to set
	 */
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}


	



	

}
