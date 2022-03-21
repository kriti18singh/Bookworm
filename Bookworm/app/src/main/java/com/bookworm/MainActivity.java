package com.bookworm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bookworm.adapters.PopularCategoryAdapter;
import com.bookworm.model.PopularCategory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mMainView;
    private List<PopularCategory> mCategoryList = new ArrayList<>();
    private PopularCategoryAdapter mCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCategoryList.add(new PopularCategory("fiction"));
        mCategoryList.add(new PopularCategory("romance"));

        mMainView = findViewById(R.id.mainRecyclerView);


        mCategoryAdapter = new PopularCategoryAdapter(mCategoryList, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mMainView.setLayoutManager(manager);
        mMainView.setAdapter(mCategoryAdapter);
    }
}