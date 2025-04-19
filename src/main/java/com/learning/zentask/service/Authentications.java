package com.learning.zentask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.zentask.model.SignUP;
import com.learning.zentask.repository.signup_repository;


@Service
public class Authentications {

    @Autowired
    signup_repository signup_repository_;

    public void saveSignUpCredentials(SignUP user){
        signup_repository_.save(user);
    }

    public boolean checkLoginDetails(String email, String password){
        return signup_repository_.findByEmailAndPassword(email, password).isPresent();
    }

}
