package com.company.empmgmtsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.empmgmtsystem.model.Department;

import com.company.empmgmtsystem.service.DepartmentService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    public List<Department> getAllDepartments() {
        return departmentService.getDepartments();
    }
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        Department department = departmentService.getDepartmentById(id);
        if (department == null) {
            throw new RuntimeException("Department not found with ID " + id);
        }
        return department;
    }
    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
    @PutMapping("/update")
    public Department updateDepartment(@PathParam(value = "id") Long id, @RequestBody Department department) {
        Department existingDepartment = departmentService.getDepartmentById(id);
        if (existingDepartment != null) {
            return departmentService.updateDepartment(id, department);
        } else {
            throw new RuntimeException("Employee not found with ID " + id);
        } 
    }
    @DeleteMapping("/delete")
    public String deleteDepartment(@PathParam(value = "id") Long id) {
        Department existingDepartment = departmentService.getDepartmentById(id);
        if (existingDepartment == null) {
            throw new RuntimeException("Department not found with ID " + id);
        }
        departmentService.deleteDepartment(id);
        return "Department with ID " + id + " has been deleted.";
    }
}
