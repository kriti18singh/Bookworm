package com.bookworm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bookworm.adapters.PopularCategoryAdapter;
import com.bookworm.model.PopularCategory;
import com.bookworm.model.VolumeInfo;

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

        //mCategoryList.add(new PopularCategory("fiction"));
        //mCategoryList.add(new PopularCategory("romance"));

        mMainView = findViewById(R.id.mainRecyclerView);



        LinearLayoutManager manager = new LinearLayoutManager(this);
        mMainView.setLayoutManager(manager);


        MainActivityViewModel model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        model.getVolumes().observe(this, new Observer<List<VolumeInfo>>() {
            @Override
            public void onChanged(@Nullable List<VolumeInfo> volumeList) {
                //mCategoryAdapter.setAdapters(new VolumeInfoAdapter(MainActivity.this, volumeList));
                mCategoryList.add(new PopularCategory("fiction", volumeList));
                mCategoryList.add(new PopularCategory("romance"));

                mCategoryAdapter = new PopularCategoryAdapter(mCategoryList, MainActivity.this);


                mMainView.setAdapter(mCategoryAdapter);
            }
        });
    }
}