package com.adidas.notification.notification_app.controllers;

import com.adidas.notification.notification_app.service.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class MailSenderController {

    @Autowired
    MailService mailService;

    @Value("${email.to}")
    String emailTo;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void send(){
        log.warn("trying to send an email");
        mailService.sendEmail(emailTo);
        log.warn("email sent");
    }
}
