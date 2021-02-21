package com.example.service.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Email Not Found")
@Log4j2
public class NoEmailFoundException extends Exception {

    public NoEmailFoundException(String search) {
        log.error("Could not find email for {}", search);
    }
}
