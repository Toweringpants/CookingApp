package com.example.cookingapp;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipeRepository {
    private static RecipeRepository instance;
    private final RecipeDao recipeDao;

    private RecipeRepository(Context context) {
        RecipeDatabase db = RecipeDatabase.getDatabase(context.getApplicationContext());
        recipeDao = db.recipeDao();
    }

    public static synchronized RecipeRepository getInstance(Context context) {
        if (instance == null) {
            instance = new RecipeRepository(context);
        }
        return instance;
    }

    public void addRecipe(Recipe recipe) {
        new Thread(() -> recipeDao.insertRecipe(recipe)).start();
    }

    public List<Recipe> getRecipesByCategory(long categoryId) {
        return recipeDao.getRecipesByCategory(categoryId);
    }

    public List<Category> getAllCategories() {
        return recipeDao.getAllCategories();
    }
}

