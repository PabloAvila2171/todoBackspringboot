package com.holamundo.demo.controller;

import com.holamundo.demo.dto.CreateTasksDto;
import com.holamundo.demo.entity.Task;
import com.holamundo.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/task")
public class taskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTask();
    }

    @GetMapping("/{taskId}")
    public Optional<Task> getTask(@PathVariable("taskId") Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping
    public CreateTasksDto createTasks(@RequestBody CreateTasksDto createTasksDto) {
         taskService.saveorupdate(createTasksDto);
         return createTasksDto;
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable("taskId") Long taskId) {
         taskService.deleteTask(taskId);
         return "se a eliminado la tarea";
    }




}
