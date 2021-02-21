package com.example.baseservice.rest;

import com.example.baseservice.exception.NoEmailFoundException;
import com.example.baseservice.model.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmailResourceTest {

    private static final String EXPECTED_BODY = "body";

    @Autowired
    EmailResource emailResource;

    @Test
//    @Sql({"src/test/java/resources/data.sql"})
    void test_getEmail_ifEmailExists_thenSuccess() throws NoEmailFoundException {
        Email newEmail = createAndSaveMail();

        Email email = emailResource.getEmail(newEmail.getId());
        assertNotNull(email);
    }

    @Test
    void test_getEmail_ifEmailNotExists_thenThrowsException() throws NoEmailFoundException {
        assertThrows(NoEmailFoundException.class, () -> {
            emailResource.getEmail(1L);
        });
    }

    @Test
    void test_createEmail_thenSuccess() {
        Email newEmail = createAndSaveMail();

        assertNotNull(newEmail);
        assertEquals(EXPECTED_BODY, newEmail.getBody());
    }

    @Test
    void test_deleteEmail_ifEmailExists_thenSuccess() throws NoEmailFoundException {
        Email newEmail = createAndSaveMail();

        emailResource.deleteEmail(newEmail.getId());

        assertThrows(NoEmailFoundException.class, () -> {
            emailResource.getEmail(newEmail.getId());
        });
    }

    @Test
    void test_deleteEmail_ifEmailNotExists_thenThrowsException() throws NoEmailFoundException {
        assertThrows(NoEmailFoundException.class, () -> {
            emailResource.deleteEmail(1L);
        });
    }

    private Email createAndSaveMail() {
        Email email = new Email(1L, "fromName", "toName", "subject", EXPECTED_BODY, List.of("label1", "label2"), Instant.now(), Instant.now());
        return emailResource.createEmail(email);
    }

}