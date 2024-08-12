package com.company.empmgmtsystem.service;

import com.company.empmgmtsystem.model.Employee;
import com.company.empmgmtsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.getReferenceById(id);
    }
    public Optional<Employee> getEmployeeByIdd(Long id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.getReferenceById(id);
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(existingEmployee);
    }

   


}
