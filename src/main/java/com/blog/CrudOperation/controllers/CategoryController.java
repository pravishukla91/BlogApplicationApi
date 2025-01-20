package com.blog.CrudOperation.controllers;

import com.blog.CrudOperation.payloads.CategoryDto;
import com.blog.CrudOperation.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Create category
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

    // Update category
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer catId) {
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, catId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    // Delete category
    @DeleteMapping("/{catId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer catId) {
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
    }

    // Get single category
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId) {
        CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    // Get all categories
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categories = this.categoryService.getCategories(); // Corrected method name
        return ResponseEntity.ok(categories);
    }
}
