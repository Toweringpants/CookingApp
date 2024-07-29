package com.example.cookingapp;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Context;

@Database(entities = {Recipe.class, Category.class}, version = 1, exportSchema = false)
public abstract class RecipeDatabase extends RoomDatabase {
    public abstract RecipeDao recipeDao();

    private static volatile RecipeDatabase INSTANCE;

    public static RecipeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RecipeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RecipeDatabase.class, "recipe_database")
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    populateInitialData(context);
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static void populateInitialData(final Context context) {
        RecipeDatabase db = getDatabase(context);
        RecipeDao recipeDao = db.recipeDao();
        new Thread(() -> {
            recipeDao.insertCategories(
                    new Category("Pastas", 1),
                    new Category("Sandwiches", 2),
                    new Category("Less than 20 Min!", 3),
                    new Category("Around the World", 4)
            );
        }).start();
    }
}