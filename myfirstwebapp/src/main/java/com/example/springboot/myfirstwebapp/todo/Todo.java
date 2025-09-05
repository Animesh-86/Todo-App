package com.example.springboot.myfirstwebapp.todo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

    public Todo() {
        // JPA requires a default constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // let DB generate id
    private int id;

    private String username;

    @Size(min = 10, message = "Description should be at least 10 characters long")
    private String description;

    private LocalDate targetDate;
    private boolean done;

    // ✅ Constructor WITH id (for testing/debugging)
    public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    // ✅ Constructor WITHOUT id (for creating new todos)
    public Todo(String username, String description, LocalDate targetDate, boolean done) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getTargetDate() { return targetDate; }
    public void setTargetDate(LocalDate targetDate) { this.targetDate = targetDate; }

    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }

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
