package com.holamundo.demo.dto;

import com.holamundo.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTasksDto {

    private String title;

    private String description;

    private User user;


}
