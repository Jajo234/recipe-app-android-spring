package com.recipeapp.backend.dto;

public class AddFavoriteRequest {

    private Long userId;
    private Long recipeId;

    public Long getUserId() {
        return userId;
    }

    public Long getRecipeId() {
        return recipeId;
    }
}
