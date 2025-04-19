package com.learning.zentask.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;


@Data
@Entity(name = "Task")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Status")
    private String status;
    @Column(name = "Created_date")
    private LocalDateTime createdDate;
    @Column(name = "Due_date")
    private LocalDate dueDate;
    @Column(name = "Priority")
    private String priority;

    @PrePersist
    protected void onCreateEvent(){
        this.createdDate = LocalDateTime.now();
    }

}
