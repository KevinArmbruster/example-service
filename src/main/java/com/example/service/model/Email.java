package com.example.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Email {

    @Id
    @GeneratedValue
    private Long id;
    private String fromName;
    private String toName;
    private String subject;
    private String body;
    @ElementCollection
    private List<String> labels;
    private Instant received;
    private Instant sent;

}
