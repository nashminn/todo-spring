package com.app.todo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String priority;
    private Boolean completed;
    private String dueDate;
    private String creationDate;



    public Todo() {
    }

    public Todo(String title, String description, String priority, Boolean completed, String dueDate, String creationDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.completed = completed;
        this.dueDate = dueDate;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        String todoStr = "Title: " + getTitle() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Priority: " + getPriority() + "\n" +
                "Completed: " + getCompleted().toString() + "\n" +
                "Creation date: " + getCreationDate() + "\n" +
                "Due date: " + getDueDate() + "\n";

        return todoStr;
    }
}
