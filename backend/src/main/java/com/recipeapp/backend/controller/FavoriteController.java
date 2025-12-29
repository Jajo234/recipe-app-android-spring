package com.recipeapp.backend.controller;

import com.recipeapp.backend.dto.AddFavoriteRequest;
import com.recipeapp.backend.model.Favorite;
import com.recipeapp.backend.service.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping
    public ResponseEntity<Void> addFavorite(
            @RequestBody AddFavoriteRequest request
    ) {
        favoriteService.addFavorite(
                request.getUserId(),
                request.getRecipeId()
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public List<Favorite> getFavoritesByUser(
            @PathVariable Long userId
    ) {
        return favoriteService.findByUser(userId);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeFavorite(@RequestParam Long userId, @RequestParam Long recipeId) {
        favoriteService.removeFavorite(userId, recipeId);
        return ResponseEntity.noContent().build();
    }
}
