package com.ecommerce.project.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.model.Category;

import java.util.ArrayList;
import java.util.Optional;
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
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        categories.remove(category);

        return "Category with categoryId: " + categoryId + " deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        // Getting category by ID
        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();
                
        // If category is found
        if (optionalCategory.isPresent()) {
            // Retrieves the value contained within an Optional object
            Category existingCategory = optionalCategory.get();

            // Updates the category name
            existingCategory.setCategoryName(category.getCategoryName());

            return existingCategory;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }

}
