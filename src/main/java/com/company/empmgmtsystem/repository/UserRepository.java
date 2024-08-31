package com.company.empmgmtsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.empmgmtsystem.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
  Users findByUsername(String username);
    
}
