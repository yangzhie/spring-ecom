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

    @Override
    public String deleteCategory(Long categoryId) {
        // Stream supports filtering, mapping and reducing
        Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst().orElse(null);

        if (category == null) {
            return "Category not found";
        }

        categories.remove(category);

        return "Category with categoryId: " + categoryId + " deleted successfully";
    }

}
