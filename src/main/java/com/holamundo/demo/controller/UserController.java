package com.holamundo.demo.controller;

import com.holamundo.demo.dto.CreateTasksDto;
import com.holamundo.demo.dto.CreateUserDto;
import com.holamundo.demo.entity.Task;
import com.holamundo.demo.entity.User;
import com.holamundo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{user_id}")
    public Optional<User> getUser(@PathVariable("user_id") Long user_id) {
        return userService.getUserById(user_id);
    }

    @PostMapping
    public CreateUserDto createUser(@RequestBody CreateUserDto user) {
        userService.createUser(user);
        return user;
    }

    @PostMapping("/{user_id}")
    public void setTasktoUser(@PathVariable("user_id") Long user_id, @RequestBody CreateTasksDto task) {
        userService.taskToUser(user_id,task);

    }

    @DeleteMapping("/{user_id}/fdjodifjg")
    public String deleteUser(@PathVariable("user_id") Long user_id) {
        userService.deleteUser(user_id);
        return "usuario eliminadoooo";
    }

    @DeleteMapping("/{user_id}/{task_id}")
    public String deleteTask(@PathVariable("user_id") Long user_id, @PathVariable("task_id")Long task_id) {
        userService.deleteTaskUser(user_id,task_id);
        return "Tarea eliminada";
    }



}
