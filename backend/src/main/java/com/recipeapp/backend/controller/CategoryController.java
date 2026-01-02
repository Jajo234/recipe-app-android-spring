package com.recipeapp.backend.controller;

import com.recipeapp.backend.dto.CategoryResponse;
import com.recipeapp.backend.dto.CreateCategoryRequest;
import com.recipeapp.backend.mapper.CategoryMapper;
import com.recipeapp.backend.model.Category;
import com.recipeapp.backend.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Crear categoria
    @PostMapping
    public ResponseEntity<CategoryResponse> create(
            @Valid @RequestBody CreateCategoryRequest request
    ) {
        Category category = categoryService.create(request.getName());
        return new ResponseEntity<>(
                CategoryMapper.toResponse(category),
                HttpStatus.CREATED
        );
    }

    //Obtener todas
    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    //Obtener por ID
    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Category update(
            @PathVariable Long id,
            @RequestBody Category category
    ) {
        return categoryService.update(id, category.getName());
    }

    // Eliminar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
