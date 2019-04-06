package com.gg.proj.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class CustomMailService {

    private JavaMailSender mailSender;

    @Autowired
    public CustomMailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendSimpleMail(String recipient, String firstName, String lastName) {

        StringBuilder text = new StringBuilder();
        SimpleMailMessage message = new SimpleMailMessage();

        // Create a message
        text.append("Hello ").append(firstName).append(" ").append(lastName).append("\n")
                .append("At least one of your loan is late, please consult your loan manager on the library's  website.");
        message.setTo(recipient);
        message.setText(text.toString());
        message.setSubject("[INFO] Late loan");

        // Send mail
        mailSender.send(message);
    }
}
