package com.example.LearningApp.controller;

import com.example.LearningApp.dto.UserDto;
import com.example.LearningApp.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
        private final UserService userService;

        @PostMapping
        public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
            UserDto createdUser = userService.createUser(userDto);
            return ResponseEntity.ok(createdUser);
        }

        @GetMapping("/{userId}")
        public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
            UserDto user = userService.getUserById(userId);
            return ResponseEntity.ok(user);
        }

        // Get User by Email
        @GetMapping("/email")
        public ResponseEntity<UserDto> getUserByEmail(@RequestParam String email) {
            UserDto user = userService.getUserByEmail(email);
            return ResponseEntity.ok(user);
        }


        @GetMapping("/login")
        public ResponseEntity<UserDto> getUserByEmailAndPassword(@RequestParam String email,
                                                                 @RequestParam String password) {
            UserDto user = userService.getUserByEmailAndPassword(email, password);
            return ResponseEntity.ok(user);
        }


        @PutMapping("/{userId}")
        public ResponseEntity<UserDto> updateUser(@PathVariable Long userId,
                                                  @RequestBody UserDto userDto) {
            UserDto updatedUser = userService.updateUserById(userId, userDto);
            return ResponseEntity.ok(updatedUser);
        }

        @DeleteMapping("/{userId}")
        public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
            String message = userService.deleteUSerById(userId);
            return ResponseEntity.ok(message);
        }
}