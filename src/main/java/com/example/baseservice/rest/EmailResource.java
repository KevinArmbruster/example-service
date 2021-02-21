package com.example.baseservice.rest;

import com.example.baseservice.exception.NoEmailFoundException;
import com.example.baseservice.model.Email;
import com.example.baseservice.service.EmailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("email")
@Log4j2
public class EmailResource {

    private final EmailService emailService;

    @Autowired
    public EmailResource(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/{id}")
    public Email getEmail(@PathVariable Long id) throws NoEmailFoundException {
        log.info("Resource call getMail: {}", id);
        return emailService.getEmail(id);
    }

    @GetMapping("emailsReceivedSince")
    public List<Email> getEmailsReceivedSince(Instant received) {
        log.info("Resource call getEmailsReceivedSince: {}", received);
        return emailService.getEmailsReceivedSince(received);
    }

    @PostMapping("createEmail")
    public Email createEmail(@RequestBody Email email) {
        log.info("Resource call createEmail: {}", email);
        return emailService.saveEmail(email);
    }

    @DeleteMapping("/{id}")
    public void deleteEmail(@PathVariable Long id) throws NoEmailFoundException {
        log.info("Resource call deleteEmail: {}", id);
        emailService.deleteMail(id);
    }

}
