package com.dsumtsov.custom.autoconfiguration.application.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
}
