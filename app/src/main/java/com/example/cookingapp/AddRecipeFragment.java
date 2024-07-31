package com.example.cookingapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class AddRecipeFragment extends Fragment {

    private EditText titleEditText;
    private EditText descriptionEditText;
    private Button buttonPastas;
    private Button buttonSandwiches;
    private Button buttonQuick;
    private Button buttonWorld;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_recipe, container, false);

        titleEditText = view.findViewById(R.id.editTextTitle);
        descriptionEditText = view.findViewById(R.id.editTextDescription);
        buttonPastas = view.findViewById(R.id.button_pastas);
        buttonSandwiches = view.findViewById(R.id.button_sandwiches);
        buttonQuick = view.findViewById(R.id.button_quick);
        buttonWorld = view.findViewById(R.id.button_world);

        navController = NavHostFragment.findNavController(this);

        buttonPastas.setOnClickListener(v -> {
            if (validateInput()) {
                addRecipeToCategory(1);
                navController.navigate(R.id.action_addRecipeFragment_to_mainFragment);
            }
        });
        buttonSandwiches.setOnClickListener(v -> {
            if (validateInput()) {
                addRecipeToCategory(2);
                navController.navigate(R.id.action_addRecipeFragment_to_mainFragment);
            }
        });
        buttonQuick.setOnClickListener(v -> {
            if (validateInput()) {
                addRecipeToCategory(3);
                navController.navigate(R.id.action_addRecipeFragment_to_mainFragment);
            }
        });
        buttonWorld.setOnClickListener(v -> {
            if (validateInput()) {
                addRecipeToCategory(4);
                navController.navigate(R.id.action_addRecipeFragment_to_mainFragment);
            }
        });

        return view;
    }

    private boolean validateInput() {
        String title = titleEditText.getText().toString();
        if (TextUtils.isEmpty(title)) {
            Toast.makeText(getContext(), "Title cannot be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (containsNumbers(title)) {
            Toast.makeText(getContext(), "Title cannot contain numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean containsNumbers(String str) {
        return str.matches(".*\\d.*");
    }

    private void addRecipeToCategory(long categoryId) {
        String title = titleEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        Recipe recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setDescription(description);
        recipe.setCategoryId(categoryId);

        RecipeRepository.getInstance(getContext()).addRecipe(recipe);
    }
}