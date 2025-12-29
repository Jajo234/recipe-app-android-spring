package com.recipeapp.backend.repository;

import com.recipeapp.backend.model.Favorite;
import com.recipeapp.backend.model.Recipe;
import com.recipeapp.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    boolean existsByUserAndRecipe(User user, Recipe recipe);

    List<Favorite> findByUserId(Long userId);

    Optional<Favorite> findByUserIdAndRecipeId(Long userId, Long recipeId);
}
