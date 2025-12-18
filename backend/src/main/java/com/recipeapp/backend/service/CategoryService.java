package com.recipeapp.backend.service;

import com.recipeapp.backend.model.Category;
import com.recipeapp.backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // 🔹 Inyección por constructor
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // 🟢 Crear categoría
    public Category create(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Category name is required");
        }

        if (categoryRepository.existsByNameIgnoreCase(name)) {
            throw new IllegalArgumentException("Category already exists");
        }

        Category category = new Category(name);
        return categoryRepository.save(category);
    }

    // 🟢 Listar todas
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // 🟢 Buscar por ID
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }

    // 🟢 Buscar por nombre
    public Category findByName(String name) {
        return categoryRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }
}
