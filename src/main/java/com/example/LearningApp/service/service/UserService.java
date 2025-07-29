package com.example.LearningApp.service.service;

import com.example.LearningApp.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    UserDto getUserByEmail(String email);
    UserDto getUserByEmailAndPassword(String email,String password);
    UserDto updateUserById(Long userId,UserDto userDto);
    String deleteUSerById(Long userId);
}
