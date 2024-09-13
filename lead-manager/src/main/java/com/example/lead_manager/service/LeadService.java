package com.example.lead_manager.service;

import com.example.lead_manager.model.Lead;
import com.example.lead_manager.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public List<Lead> findAll() {
        return leadRepository.findAll();
    }

    public Optional<Lead> findById(Long id) {
        return leadRepository.findById(id);
    }

    public List<Lead> findBySourceId(Long sourceId) {
        return leadRepository.findBySourceId(sourceId);
    }

   public Lead save(Lead lead) {
        if (lead.getDataCadastro() == null) {
            lead.setDataCadastro(java.sql.Timestamp.valueOf(LocalDateTime.now()));
        }
        return leadRepository.save(lead);
    }

    public void deleteById(Long id) {
        leadRepository.deleteById(id);
    }
}
