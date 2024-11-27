package com.ecommerce.project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.project.model.Category;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    // List of Category objects, initizalized as empty ArrayList
    private List<Category> categories = new ArrayList<>();

    // Returns the list of Category objects
    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return categories;
    }
}
