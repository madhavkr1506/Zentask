package com.learning.zentask.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.zentask.model.Task;

@Repository
public interface Task_Repository extends JpaRepository<Task, Long>{
    List<Task> findByTitle(String title);

    @Modifying
    @Query("delete from Task t where t.dueDate = :dueDate")
    void deleteTaskByDueDate(@Param("dueDate") LocalDate due_date);
}
