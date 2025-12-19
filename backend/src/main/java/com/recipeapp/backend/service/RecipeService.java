package com.recipeapp.backend.service;

import com.recipeapp.backend.model.Category;
import com.recipeapp.backend.model.Recipe;
import com.recipeapp.backend.model.User;
import com.recipeapp.backend.repository.CategoryRepository;
import com.recipeapp.backend.repository.RecipeRepository;
import com.recipeapp.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public RecipeService(
            RecipeRepository recipeRepository,
            UserRepository userRepository,
            CategoryRepository categoryRepository
    ) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public Recipe createRecipe(
            Long userId,
            Long categoryId,
            String title,
            String description,
            String ingredients,
            String steps,
            String imageUrl

    ) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        Recipe recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setDescription(description);
        recipe.setIngredients(ingredients);
        recipe.setSteps(steps);
        recipe.setImageUrl(imageUrl);
        recipe.setUser(user);
        recipe.setCategory(category);

        return recipeRepository.save(recipe);
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public List<Recipe> findByUser(Long userId) {
        return recipeRepository.findByUserId(userId);
    }

    public List<Recipe> findByCategory(Long categoryId) {
        return recipeRepository.findByCategoryId(categoryId);
    }

    public List<Recipe> searchByTitle(String title) {
        return recipeRepository.findByTitleContainingIgnoreCase(title);
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found"));
    }

    public void delete(Long recipeId, Long userId) {
        Recipe recipe = findById(recipeId);

        if (!recipe.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("You are not allowed to delete this recipe");
        }

        recipeRepository.delete(recipe);
    }
}
