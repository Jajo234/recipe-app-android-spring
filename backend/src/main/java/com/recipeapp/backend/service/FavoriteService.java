package com.recipeapp.backend.service;

import com.recipeapp.backend.model.Favorite;
import com.recipeapp.backend.model.Recipe;
import com.recipeapp.backend.model.User;
import com.recipeapp.backend.repository.FavoriteRepository;
import com.recipeapp.backend.repository.RecipeRepository;
import com.recipeapp.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    public FavoriteService(FavoriteRepository favoriteRepository, UserRepository userRepository, RecipeRepository recipeRepository) {
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    public void addFavorite(Long userId, Long recipeId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found"));

        boolean exits = favoriteRepository.existsByUserAndRecipe(user, recipe);
        if (exits) {
            throw new IllegalArgumentException("Recipe already in favorites");
        }

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setRecipe(recipe);

        favoriteRepository.save(favorite);

    }

    public List<Favorite> findByUser(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

    public void removeFavorite(Long userId, Long recipeId) {
        Favorite favorite = favoriteRepository
                .findByUserIdAndRecipeId(userId, recipeId)
                .orElseThrow(() -> new IllegalArgumentException("Favorite not found"));
        favoriteRepository.delete(favorite);
    }
}
