package com.ecommerce.project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    // Constructor handles incoming traffic from CategoryService
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Returns the list of Category objects
    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "Category added successfully";
    }

}
