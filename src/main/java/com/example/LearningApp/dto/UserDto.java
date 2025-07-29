package com.example.LearningApp.dto;

import com.example.LearningApp.enums.UserStatus;
import lombok.Data;


@Data
public class UserDto {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private Long mobileNumber;
    private UserStatus userStatus;
}
