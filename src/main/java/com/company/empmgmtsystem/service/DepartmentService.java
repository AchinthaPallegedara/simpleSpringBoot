package com.company.empmgmtsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.empmgmtsystem.model.Department;
import com.company.empmgmtsystem.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public Department getDepartmentById(Long id) {
        return departmentRepository.getReferenceById(id);
    }
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
    public Department updateDepartment(Long id, Department department) {
        Department existingDepartment = departmentRepository.getReferenceById(id);
        existingDepartment.setName(department.getName());
        return departmentRepository.save(existingDepartment);
    }
}
