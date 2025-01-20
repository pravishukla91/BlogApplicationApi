package com.blog.CrudOperation.services.impl;

import com.blog.CrudOperation.entities.Category;
import com.blog.CrudOperation.exceptions.ResourceNotFoundExceptions;
import com.blog.CrudOperation.payloads.CategoryDto;
import com.blog.CrudOperation.repositories.CategoryRepo;
import com.blog.CrudOperation.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundExceptions("Category", "Category Id", categoryId ));
        return null;
    }

    @Override
    public void deleteCategory(Integer categoryId) {

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<CategoryDto> getCategories() {
        return List.of();
    }
}
