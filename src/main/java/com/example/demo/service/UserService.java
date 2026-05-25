package com.example.demo.service;

import com.example.demo.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser();
    List<UserDTO> getUsers();
}
