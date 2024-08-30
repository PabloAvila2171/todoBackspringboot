package com.holamundo.demo.converter;

import com.holamundo.demo.dto.CreateTasksDto;
import com.holamundo.demo.entity.Task;
import org.springframework.stereotype.Component;


@Component
public class TaskConverter extends AbstractConverter<Task, CreateTasksDto> {


    @Override
    public CreateTasksDto fromEntity(Task entity) {
        if (entity == null) return null;
        return CreateTasksDto.builder()
                .title(entity.getTitle())
                .description(entity.getDescription())
                .user(entity.getUser())
                .build();
    }

    @Override
    public Task fromDTO(CreateTasksDto dto) {
        if (dto == null) return null;
        return Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .user(dto.getUser())
                .build();
    }

}
