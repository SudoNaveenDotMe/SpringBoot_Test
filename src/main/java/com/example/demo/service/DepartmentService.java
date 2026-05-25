package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO saveDepartment();
    List<DepartmentDTO> getDepartment();
}
