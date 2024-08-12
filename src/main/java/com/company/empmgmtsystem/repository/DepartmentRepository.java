package com.company.empmgmtsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.company.empmgmtsystem.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
