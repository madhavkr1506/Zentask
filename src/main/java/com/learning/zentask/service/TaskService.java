package com.learning.zentask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.zentask.model.Task;
import com.learning.zentask.repository.Task_Repository;

@Service
public class TaskService {

    @Autowired
    Task_Repository task_Repository;

    public void saveTask(Task taskDetails){
        task_Repository.save(taskDetails);
    }


    public List<Task> getAllTask(){
        return task_Repository.findAll();
    }

    public boolean deleteTaskByTitle(String title) {
        List<Task> tasks = task_Repository.findByTitle(title);
        if (tasks.isEmpty()) {
            return false;
        }
        task_Repository.deleteAll(tasks);
        return true;
    }

}
