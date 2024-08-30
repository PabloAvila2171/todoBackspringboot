package com.holamundo.demo.service;



import com.holamundo.demo.converter.TaskConverter;
import com.holamundo.demo.dto.CreateTasksDto;
import com.holamundo.demo.entity.Task;
import com.holamundo.demo.repository.TaskRepository;
import com.holamundo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskConverter taskConverter;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository, TaskConverter taskConverter) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskConverter = taskConverter;
    }

    public List<Task> getAllTask() {

       return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void saveorupdate(CreateTasksDto createTasksDto) {

        Task task = taskConverter.fromDTO(createTasksDto);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }



}
