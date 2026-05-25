package com.example.demo.dto;

import com.example.demo.enumaration.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long userId;
    private String firstName;
    private String lastName;
    private Date dob;
    private UserStatus userStatus;
}
