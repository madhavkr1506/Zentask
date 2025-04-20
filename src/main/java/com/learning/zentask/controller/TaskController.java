package com.learning.zentask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.zentask.model.SignUP;
import com.learning.zentask.model.Task;
import com.learning.zentask.service.Authentications;
import com.learning.zentask.service.TaskService;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    Authentications authentications;

    @Autowired
    TaskService taskService;

    @GetMapping("/")
    public String getLoginPage() {
        return "Authentications";
    }

    @PostMapping("/signup-form")
    public String getSignUpDetails(@ModelAttribute SignUP user) {
        authentications.saveSignUpCredentials(user);
        return "login-success";
    }

    @PostMapping("/login-form")
    public String getLoginDetails(@RequestParam String email, @RequestParam String password) {
        if (authentications.checkLoginDetails(email, password)) {
            return "login-success";
        }
        return "login-failed";
    }

    @PostMapping("/fill-task")
    public String getTaskdetails(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/task?success=true";
    }

    @GetMapping("/task")
    public String displayAllTask(Model model) {
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks", tasks);
        return "task";
    }

    @DeleteMapping("/deleteByTitle/{title}")
    public ResponseEntity<String> deleteTaskByTitle(@PathVariable String title) {
        boolean deleted = taskService.deleteTaskByTitle(title);
        if (deleted) {
            return ResponseEntity.ok("Task deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No task found with that title.");
        }
    }

}
