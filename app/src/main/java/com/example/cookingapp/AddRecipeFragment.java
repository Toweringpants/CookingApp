package com.example.cookingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class AddRecipeFragment extends Fragment {

    private EditText editTextTitle;
    private EditText editTextDescription;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_recipe, container, false);

        editTextTitle = view.findViewById(R.id.editTextTitle);
        editTextDescription = view.findViewById(R.id.editTextDescription);
        Button buttonFinish = view.findViewById(R.id.buttonFinish);

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRecipe();
                Navigation.findNavController(v).navigate(R.id.action_addRecipeFragment_to_mainFragment);
            }
        });

        return view;
    }

    private void saveRecipe() {
        // TODO: Implement logic to save the recipe
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        // Save the title and description to storage
    }
}
