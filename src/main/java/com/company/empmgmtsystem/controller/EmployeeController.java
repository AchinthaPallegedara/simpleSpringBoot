package com.company.empmgmtsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.empmgmtsystem.model.Employee;
import com.company.empmgmtsystem.service.EmployeeService;

import jakarta.websocket.server.PathParam;


import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin()
@RequestMapping("/api/v1/employee") 
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping()
    public List<Employee> getAllEmployees() {
       return employeeService.getEmployees();
    }
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeByIdd(id);
    }
    @PostMapping("/add")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/delete")
    public String deleteEmployee(@PathParam(value = "id") Long id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID " + id + " has been deleted.";
    }

    @PutMapping("/update")
    public Employee updateEmployee(@PathParam(value = "id") Long id, @RequestBody Employee employeeDetails) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            return employeeService.updateEmployee(id, employeeDetails);
        } else {
            // Handle the case where the employee does not exist
            throw new RuntimeException("Employee not found with ID " + id);
        } 
    }
    


}
