package com.learning.zentask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.zentask.model.Task;

@Repository
public interface Task_Repository extends JpaRepository<Task, Long>{
    List<Task> findByTitle(String title);
}
