package com.adidas.notification.notification_app.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService{


    @Autowired
    private final MailSender mailSender;


    @Override
    public void sendEmail(String email) throws MailException {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setSubject("Testing Mail API");
        mail.setText("Hurray ! You have done that dude...");

        mailSender.send(mail);
    }
}
