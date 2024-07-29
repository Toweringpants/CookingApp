package com.example.cookingapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {
    @Insert
    void insertCategories(Category... categories);

    @Insert
    void insertRecipe(Recipe recipe);

    @Query("SELECT * FROM categories")
    List<Category> getAllCategories();

    @Query("SELECT * FROM recipes WHERE mCategoryId = :categoryId")
    List<Recipe> getRecipesByCategory(long categoryId);
}
