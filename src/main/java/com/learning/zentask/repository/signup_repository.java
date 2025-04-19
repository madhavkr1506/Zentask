package com.learning.zentask.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.zentask.model.SignUP;


@Repository
public interface signup_repository extends JpaRepository<SignUP, Long>{

    Optional<SignUP> findByEmailAndPassword(String email, String password);
}
