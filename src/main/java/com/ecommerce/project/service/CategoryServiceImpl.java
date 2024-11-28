package com.ecommerce.project.service;

import org.springframework.stereotype.Service;

import com.ecommerce.project.model.Category;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    // List of Category objects, initizalized as empty ArrayList
    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);
    }

}
