package com.example.lead_manager.repository;

import com.example.lead_manager.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    List<Lead> findBySourceId(Long sourceId);
}
