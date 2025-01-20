package com.blog.CrudOperation.services.impl;

import com.blog.CrudOperation.entities.Category;
import com.blog.CrudOperation.exceptions.ResourceNotFoundExceptions;
import com.blog.CrudOperation.payloads.CategoryDto;
import com.blog.CrudOperation.repositories.CategoryRepo;
import com.blog.CrudOperation.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        // Map CategoryDto to Category
        Category cat = this.modelMapper.map(categoryDto, Category.class);

        // Save the category in the database
        Category addedCat = this.categoryRepo.save(cat);

        // Map saved Category back to CategoryDto
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        // Find the category by ID or throw exception if not found
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() ->new ResourceNotFoundExceptions("Category", "Category Id", categoryId));

        // Update the category's fields
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());

        // Save updated category and map to CategoryDto
        Category updatedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        // Find the category by ID or throw exception if not found
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Category", "Category Id", categoryId));

        // Delete the category
        this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        // Find the category by ID or throw exception if not found
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Category", "Category Id", categoryId));

        // Map to CategoryDto
        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        // Fetch all categories and map each to CategoryDto
        List<Category> categories = this.categoryRepo.findAll();
        return categories.stream()
                .map(cat -> this.modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());
    }
}
