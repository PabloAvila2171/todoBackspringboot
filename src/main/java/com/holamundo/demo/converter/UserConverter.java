package com.holamundo.demo.converter;

import com.holamundo.demo.dto.CreateUserDto;
import com.holamundo.demo.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserConverter extends AbstractConverter <User, CreateUserDto>{


    @Override
    public CreateUserDto fromEntity(User entity) {
        if (entity == null) return null;
        return CreateUserDto.builder()
                .email(entity.getEmail())
                .password(entity.getPassword())
                .username(entity.getUsername())
                .build();
    }

    @Override
    public User fromDTO(CreateUserDto dto) {
        if (dto == null) return null;
        return User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .username(dto.getUsername())
                .build();
    }
}
