package com.emergency.project;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emergency.project.mail.Email;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingApplicationTests {

	@Test
	public void contextLoads() {
	
		System.out.println("Sending email to user!!!");
		Email email = new Email();
		System.out.println("Email Sent Successfully!!!");
	
	}

}
