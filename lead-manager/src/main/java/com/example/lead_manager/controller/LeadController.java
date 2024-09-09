package com.example.lead_manager.controller;

import com.example.lead_manager.model.Lead;
import com.example.lead_manager.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable Long id) {
        Optional<Lead> lead = leadService.findById(id);
        return lead.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lead createLead(@RequestBody Lead lead) {
        return leadService.save(lead);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(@PathVariable Long id, @RequestBody Lead leadDetails) {
        Optional<Lead> lead = leadService.findById(id);
        if (lead.isPresent()) {
            Lead updatedLead = lead.get();
            updatedLead.setNome(leadDetails.getNome());
            updatedLead.setEmail(leadDetails.getEmail());
            updatedLead.setTelefone(leadDetails.getTelefone());
            updatedLead.setSource(leadDetails.getSource());
            updatedLead.setUser(leadDetails.getUser());
            return ResponseEntity.ok(leadService.save(updatedLead));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        leadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
