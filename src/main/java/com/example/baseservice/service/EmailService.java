package com.example.baseservice.service;

import com.example.baseservice.exception.NoEmailFoundException;
import com.example.baseservice.model.Email;
import com.example.baseservice.repository.EmailRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EmailService {

    private final EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public Email getEmail(Long id) throws NoEmailFoundException {
        Optional<Email> email = emailRepository.findById(id);
        if (email.isPresent()) {
            return email.get();
        } else {
            throw new NoEmailFoundException(id.toString());
        }
    }

    public List<Email> getEmailsReceivedSince(Instant receivedDate) {
        return emailRepository.findEmailByReceivedGreaterThanEqual(receivedDate);
    }

    public Email saveEmail(Email email) {
        return emailRepository.save(email);
    }

    public void deleteMail(Long id) throws NoEmailFoundException {
        try {
            emailRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoEmailFoundException(id.toString());
        }
    }

}
