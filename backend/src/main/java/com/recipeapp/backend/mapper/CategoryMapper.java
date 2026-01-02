package com.recipeapp.backend.mapper;

import com.recipeapp.backend.dto.CategoryResponse;
import com.recipeapp.backend.model.Category;

public class CategoryMapper {

    private CategoryMapper() {
        // evita instancias
    }

    public static CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }
}
