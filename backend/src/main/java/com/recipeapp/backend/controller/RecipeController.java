package com.recipeapp.backend.controller;

import com.recipeapp.backend.dto.CreateRecipeRequest;
import com.recipeapp.backend.dto.RecipeResponse;
import com.recipeapp.backend.mapper.RecipeMapper;
import com.recipeapp.backend.model.Recipe;
import com.recipeapp.backend.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<RecipeResponse> createRecipe(
            @RequestBody CreateRecipeRequest request
    ) {
        Recipe recipe = recipeService.createRecipe(
                request.getUserId(),
                request.getCategoryId(),
                request.getTitle(),
                request.getDescription(),
                request.getIngredients(),
                request.getSteps(),
                request.getImageUrl()
        );

        RecipeResponse response = RecipeMapper.toResponse(recipe);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<RecipeResponse> getAllRecipes() {
        return recipeService.findAll()
                .stream()
                .map(RecipeMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public RecipeResponse getRecipeById(@PathVariable Long id) {
        return RecipeMapper.toResponse(recipeService.findById(id));
    }

    @GetMapping("/search")
    public List<RecipeResponse> searchByTitle(@RequestParam String title) {
        return recipeService.searchByTitle(title)
                .stream()
                .map(RecipeMapper::toResponse)
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(
            @PathVariable Long id,
            @RequestParam Long userId
    ) {
        recipeService.delete(id, userId);
        return ResponseEntity.noContent().build();
    }
}
