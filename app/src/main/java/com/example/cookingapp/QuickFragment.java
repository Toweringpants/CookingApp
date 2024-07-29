package com.example.cookingapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class QuickFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    private long categoryId;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quick, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecipeAdapter();
        recyclerView.setAdapter(adapter);

        categoryId = 3;

        navController = NavHostFragment.findNavController(this);

        new Thread(() -> {
            List<Recipe> recipes = RecipeRepository.getInstance(getContext()).getRecipesByCategory(categoryId);
            getActivity().runOnUiThread(() -> adapter.submitList(recipes));
        }).start();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.buttonBack).setOnClickListener(v -> navController.navigate(R.id.action_quickFragment_to_mainFragment));
        Button buttonAddRecipe = getActivity().findViewById(R.id.buttonAddRecipe);
        if (buttonAddRecipe != null) {
            buttonAddRecipe.setVisibility(View.GONE);
        }
    }
}
