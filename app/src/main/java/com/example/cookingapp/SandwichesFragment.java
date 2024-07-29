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

import java.util.List;

public class SandwichesFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    private long categoryId;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sandwiches, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecipeAdapter();
        recyclerView.setAdapter(adapter);

        categoryId = 2;

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
        view.findViewById(R.id.buttonBack).setOnClickListener(v -> navController.navigate(R.id.action_sandwichesFragment_to_mainFragment));
    }
}
