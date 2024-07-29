package com.example.cookingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {
    private static RecipeDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = Room.databaseBuilder(getApplicationContext(), RecipeDatabase.class, "recipe_database")
                .fallbackToDestructiveMigration()
                .build();
        setContentView(R.layout.activity_main);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();

            Button buttonAddRecipe = findViewById(R.id.buttonAddRecipe);
            buttonAddRecipe.setOnClickListener(view -> navController.navigate(R.id.action_mainFragment_to_addRecipeFragment));

            Button buttonPastas = findViewById(R.id.button_pastas);
            buttonPastas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navController.navigate(R.id.action_mainFragment_to_pastasFragment);
                }
            });

            Button buttonSandwiches = findViewById(R.id.button_sandwiches);
            buttonSandwiches.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navController.navigate(R.id.action_mainFragment_to_sandwichesFragment);
                }
            });

            Button buttonQuick = findViewById(R.id.button_quick);
            buttonQuick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navController.navigate(R.id.action_mainFragment_to_quickFragment);
                }
            });

            Button buttonWorld = findViewById(R.id.button_world);
            buttonWorld.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navController.navigate(R.id.action_mainFragment_to_worldFragment);
                }
            });
        }
    }

    public static RecipeDatabase getDatabase() {
        return database;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            return navController.navigateUp() || super.onSupportNavigateUp();
        }
        return super.onSupportNavigateUp();
    }
}
