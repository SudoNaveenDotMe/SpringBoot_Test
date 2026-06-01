package com.example.demo.service.impl;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.User;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        log.info("Execute method saveDepartment" + departmentDTO);

        /*Department department = new Department();
        department.setDepartmentName("HR");
        department.setDepartmentLocation("Colombo");

        Department dep = departmentRepository.save(department);
        DepartmentDTO responseDepartmentDTO = new DepartmentDTO();

        responseDepartmentDTO.setDepartmentName(dep.getDepartmentName());
        responseDepartmentDTO.setDepartmentLocation(dep.getDepartmentLocation());

        log.info("Saved User Returned");
        return responseDepartmentDTO;*/

        Department department = new Department();
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setDepartmentLocation(departmentDTO.getDepartmentLocation());

        Department dep = departmentRepository.save(department);
        DepartmentDTO responseDepartmentDTO = new DepartmentDTO();

        responseDepartmentDTO.setDepartmentName(dep.getDepartmentName());
        responseDepartmentDTO.setDepartmentLocation(dep.getDepartmentLocation());

        log.info("Saved Department Returned");
        return responseDepartmentDTO;
    }

    @Override
    public List<DepartmentDTO> getDepartment() {
        log.info("Execute method getDepartments");
        try{
            List<DepartmentDTO> responseList = new ArrayList<>();
            List<Department> departmentList = departmentRepository.findAll();

            for (Department department : departmentList){
                DepartmentDTO dto = new DepartmentDTO();
                dto.setDepartmentId(department.getDepartmentId());
                dto.setDepartmentName(department.getDepartmentName());
                dto.setDepartmentLocation(department.getDepartmentLocation());

                responseList.add(dto);
            }

            return responseList;

        }catch (Exception e){
            log.info("Error in method getDepartments :" + e.getMessage());
            throw e;
        }
    }
}
