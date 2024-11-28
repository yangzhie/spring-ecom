package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;

import java.util.List;

// Declaration of all methods
public interface CategoryService {

    List<Category> getAllCategories();

    void createCategory(Category category);
    
}
