package com.recipeapp.backend.repository;

import com.recipeapp.backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByUserId(Long userId);

    List<Recipe> findByCategoryId(Long categoryId);

    List<Recipe> findByTitleContainingIgnoreCase(String title);
}
