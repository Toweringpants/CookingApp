package com.example.cookingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();

            FloatingActionButton fabAddRecipe = findViewById(R.id.fabAddRecipe);
            fabAddRecipe.setOnClickListener(view -> navController.navigate(R.id.action_mainFragment_to_addRecipeFragment));

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
