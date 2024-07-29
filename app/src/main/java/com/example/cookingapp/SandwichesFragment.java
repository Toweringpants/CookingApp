package com.example.cookingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SandwichesFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    private long categoryId;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sandwiches, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecipeAdapter();
        recyclerView.setAdapter(adapter);

        categoryId = 2;

        new Thread(() -> {
            List<Recipe> recipes = RecipeRepository.getInstance(getContext()).getRecipesByCategory(categoryId);
            getActivity().runOnUiThread(() -> adapter.submitList(recipes));
        }).start();

        return view;
    }
}