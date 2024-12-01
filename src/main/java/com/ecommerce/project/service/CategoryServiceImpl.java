package com.ecommerce.project.service;

import org.springframework.stereotype.Service;

import com.ecommerce.project.model.Category;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    // List of Category objects, initizalized as empty ArrayList
    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L; // Tracks IDs

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
    }

}
