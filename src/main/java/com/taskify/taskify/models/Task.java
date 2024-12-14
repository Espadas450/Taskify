package com.taskify.taskify.models;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotBlank(message = "Title cannot be blank!")
    private String title;

    private String description;

    @NotNull(message = "Status cannot be null!")
    private Status status;

    // Get/Set
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void SetTitle(String title){
        this.title = title;
    }

    public String getDescription(String description){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status description){
        this.status = description;
    }
}
