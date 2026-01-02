package com.recipeapp.backend.service;

import com.recipeapp.backend.model.Category;
import com.recipeapp.backend.repository.CategoryRepository;
import com.recipeapp.backend.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;

    // 🔹 Inyección por constructor
    public CategoryService(
            CategoryRepository categoryRepository,
            RecipeRepository recipeRepository
    ) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    // 🟢 Crear categoría
    public Category create(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Category name is required");
        }

        if (categoryRepository.existsByNameIgnoreCase(name)) {
            throw new IllegalArgumentException("Category already exists");
        }

        Category category = new Category();
        category.setName(name);

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

    public Category update(Long id, String name){
        Category category = findById(id);
        category.setName(name);
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        if (recipeRepository.existsByCategoryId(id)) {
            throw new IllegalStateException(
                    "Cannot delete category because it has associated recipes"
            );
        }

        categoryRepository.delete(category);
    }

}
