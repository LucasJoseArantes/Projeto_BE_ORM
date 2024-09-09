package com.example.lead_manager.controller;

import com.example.lead_manager.model.Source;
import com.example.lead_manager.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sources")
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @GetMapping
    public List<Source> getAllSources() {
        return sourceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Source> getSourceById(@PathVariable Long id) {
        Optional<Source> source = sourceService.findById(id);
        return source.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Source createSource(@RequestBody Source source) {
        return sourceService.save(source);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Source> updateSource(@PathVariable Long id, @RequestBody Source sourceDetails) {
        Optional<Source> source = sourceService.findById(id);
        if (source.isPresent()) {
            Source updatedSource = source.get();
            updatedSource.setNome(sourceDetails.getNome());
            updatedSource.setDescricao(sourceDetails.getDescricao());
            return ResponseEntity.ok(sourceService.save(updatedSource));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSource(@PathVariable Long id) {
        sourceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
