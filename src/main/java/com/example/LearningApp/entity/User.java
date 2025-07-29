package com.example.LearningApp.entity;

import com.example.LearningApp.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private Long mobileNumber;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus; // "USER", "ADMIN"
}
