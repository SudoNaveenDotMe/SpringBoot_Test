package com.example.demo.entity;

import com.example.demo.enumaration.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String firstName;
    private String lastName;
    private Date dob;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

}
