package com.springboot.TodoWebApp.todo;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

//@Entity(name = "someThing") => this name will be used to name the Entity
//@Table(name = "someThing")  => this name will be used to name a table in DB
@Entity
@Table
public class Todo {

    public Todo(Long id, String username, String description, LocalDate targetDate, String done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public Todo(String username, String description, LocalDate targetDate, String done) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public Todo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @Size(min=10, message="Enter at least 10 characters")
    private String description;
    private LocalDate targetDate;
    private String done;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}