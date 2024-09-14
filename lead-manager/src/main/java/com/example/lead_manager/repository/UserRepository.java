package com.example.lead_manager.repository;

import com.example.lead_manager.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    UserDetails findByUsername(String username);
}
