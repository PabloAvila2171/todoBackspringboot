package com.holamundo.demo.repository;

import com.holamundo.demo.dto.CreateTasksDto;
import com.holamundo.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
