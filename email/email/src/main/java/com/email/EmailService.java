package com.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    public void sendSimpleEmail(String toEmail , String body , String subject){

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("mafham37@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setText(body);
        mailMessage.setSubject(subject);

        mailSendd(mailMessage);
        System.out.println("Email is send :   ");
    }



    public void sendEmailWithAttachment(String to, String subject, String body,String attachment) throws MessagingException, IOException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("mafham37@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);

        FileSystemResource file = new FileSystemResource(new File(attachment));
        helper.addAttachment(file.getFilename(),file);

        mailSender.send(message);
        System.out.println("attachment messsage send :    ");
    }
}
