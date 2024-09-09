package com.example.lead_manager.controller;

import com.example.lead_manager.model.Lead;
import com.example.lead_manager.model.Tag;
import com.example.lead_manager.service.TagService;

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
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    @Operation(summary = "Get all tags", description = "Retrieve a list of all tags")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", 
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = Tag.class))),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public List<Tag> getAllTags() {
        return tagService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get tag by ID", description = "Retrieve a tag by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", 
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = Tag.class))),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public ResponseEntity<Tag> getTagById(@PathVariable Long id) {
        Optional<Tag> tag = tagService.findById(id);
        return tag.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new tag", description = "Create a new tag with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created", 
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = Tag.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing tag", description = "Updates the tag with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", 
            content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = Tag.class))),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tagDetails) {
        Optional<Tag> tag = tagService.findById(id);
        if (tag.isPresent()) {
            Tag updatedTag = tag.get();
            updatedTag.setNome(tagDetails.getNome());
            return ResponseEntity.ok(tagService.save(updatedTag));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a tag", description = "Deletes the tag with the specified ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "No Content", content = @Content),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
