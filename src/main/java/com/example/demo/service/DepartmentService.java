package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
    List<DepartmentDTO> getDepartment();
}
