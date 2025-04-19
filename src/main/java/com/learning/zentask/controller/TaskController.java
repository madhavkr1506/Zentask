package com.learning.zentask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    @GetMapping("/authentication")
    public String getLoginPage(){
        return "Authentications";
    }

    @PostMapping("/signup-form")
    public String getSignUpDetails(@ModelAttribute SignUP user){
        authentications.saveSignUpCredentials(user);
        return "login-success";
    }

    @PostMapping("/login-form")
    public String getLoginDetails(@RequestParam String email, @RequestParam String password ) {
        if (authentications.checkLoginDetails(email, password)){
            return "login-success";
        }
        return "login-failed";
    }

    @PostMapping("/save-task")
    public String saveTask(@ModelAttribute Task taskdetails){
        taskService.saveTask(taskdetails);
        return "redirect:/save-task?success=true";
    }

    @GetMapping("/save-task")
    public String getAllTask(Model model){
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks", tasks);
        
        return "task";
    }
}
