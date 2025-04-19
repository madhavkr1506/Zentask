package com.learning.zentask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "SignUp")
public class SignUP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;
    @Column(name = "FirstName")
    private String firstname;
    @Column(name = "LastName")
    private String lastname;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;


}
