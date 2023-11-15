package com.email;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class EmailApplication {

	@Autowired
	EmailService service;
	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)  // it is used to auto triger the app on every run of application
//	public void trigerEmail() throws MessagingException, IOException {
//		service.sendSimpleEmail("mafham678@gmail.com" , "this is the email body" , "this is the subject");
//	}

	@EventListener(ApplicationReadyEvent.class)  // it is used to auto triger the app on every run of application
	public void trigerEmail() throws MessagingException, IOException {
		service.sendEmailWithAttachment("mafham678@gmail.com" , "this is the email body" , "this is the subject","C:\\Users\\Muhammad Afham\\Downloads\\afham.jpg");
	}
}
