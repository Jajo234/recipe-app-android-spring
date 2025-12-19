package com.recipeapp.backend.mapper;

import com.recipeapp.backend.dto.RecipeResponse;
import com.recipeapp.backend.model.Recipe;

public class RecipeMapper {

    public static RecipeResponse toResponse(Recipe recipe) {
        RecipeResponse dto = new RecipeResponse();
        dto.setId(recipe.getId());
        dto.setTitle(recipe.getTitle());
        dto.setDescription(recipe.getDescription());
        dto.setIngredients(recipe.getIngredients());
        dto.setSteps(recipe.getSteps());
        dto.setImageUrl(recipe.getImageUrl());
        dto.setCreatedAt(recipe.getCreatedAt());

        dto.setUserId(recipe.getUser().getId());
        dto.setUserEmail(recipe.getUser().getEmail());

        dto.setCategoryId(recipe.getCategory().getId());
        dto.setCategoryName(recipe.getCategory().getName());

        return dto;
    }
}
