package com.example.lead_manager.controller;

import com.example.lead_manager.model.Source;
import com.example.lead_manager.service.SourceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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
    @Operation(summary = "Get all sources", description = "Retrieve a list of all sources")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", 
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = Source.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public List<Source> getAllSources() {
        return sourceService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get source by ID", description = "Retrieve a source by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", 
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = Source.class))),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public ResponseEntity<Source> getSourceById(@PathVariable Long id) {
        Optional<Source> source = sourceService.findById(id);
        return source.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new source", description = "Create a new source with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created", 
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = Source.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public Source createSource(@RequestBody Source source) {
        return sourceService.save(source);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing source", description = "Update the source with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", 
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = Source.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
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
    @Operation(summary = "Delete a source", description = "Delete a source by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "No Content", content = @Content),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public ResponseEntity<Void> deleteSource(@PathVariable Long id) {
        sourceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
