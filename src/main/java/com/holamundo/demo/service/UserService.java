package com.holamundo.demo.service;


import com.holamundo.demo.converter.TaskConverter;
import com.holamundo.demo.converter.UserConverter;
import com.holamundo.demo.dto.CreateTasksDto;
import com.holamundo.demo.dto.CreateUserDto;
import com.holamundo.demo.entity.Task;
import com.holamundo.demo.entity.User;
import com.holamundo.demo.repository.TaskRepository;
import com.holamundo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final UserConverter userConverter;
    private final TaskConverter taskConverter;


    @Autowired
    public UserService(UserRepository userRepository, TaskRepository taskRepository, UserConverter userConverter, TaskConverter taskConverter) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.userConverter = userConverter;
        this.taskConverter = taskConverter;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void createUser(CreateUserDto createUserDto) {
        try{
            User user = userConverter.fromDTO(createUserDto);
            userRepository.save(user);
        }catch (DataIntegrityViolationException e) {
            // Manejo de la violación de clave única
            throw new RuntimeException("El correo electrónico ya esta siendo utilizado.");
        }


    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void taskToUser(Long id, CreateTasksDto createTasksDto) {
       User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("El usuario no existe"));
       createTasksDto.setUser(user);
       Task task = taskConverter.fromDTO(createTasksDto);
       taskRepository.save(task);

    }









}
