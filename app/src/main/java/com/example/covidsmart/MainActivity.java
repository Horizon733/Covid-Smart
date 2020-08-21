package com.example.covidsmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.covidsmart.adapters.CategoryRecyclerViewAdapter;
import com.example.covidsmart.databinding.ActivityMainBinding;
import com.example.covidsmart.models.Category;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.list);
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(R.string.category_detector,R.drawable.ic_mask));
        categories.add(new Category(R.string.category_covid_bot,R.drawable.ic_virus));
        categories.add(new Category(R.string.category_social_distancing,R.drawable.ic_social_distancing));
       LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        CategoryRecyclerViewAdapter adapter = new  CategoryRecyclerViewAdapter(categories,this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}