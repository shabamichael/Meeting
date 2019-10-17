package com.emergency.project;


import java.util.Collections;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class MeetingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(MeetingApplication.class, args);
		
		
		//This will escape the controller and directly create a meeting then save into the database
		MeetingService meetingService  = applicationContext.getBean("meetingService", MeetingService.class)	;
		
		Meeting meeting = new Meeting();
		meeting.setMeetingDate(new Date());
		meeting.setAttendance(200);
		meeting.setAnnouncement("Nzehs's group is cleaning the hall today");
		meeting.setAttendant("Michael Shaba");
		meeting.setMeetingDay("Sunday");
		meeting.setMeetingType("Weekend meeting");
		meeting.setSoundOperator("Gani Banda");
		
		meetingService.saveMeeting(meeting);
		
	}

	
}
