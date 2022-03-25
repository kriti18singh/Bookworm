package com.bookworm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SearchView;

import com.bookworm.adapters.PopularCategoryAdapter;
import com.bookworm.model.PopularCategory;
import com.bookworm.model.VolumeInfo;
import com.bookworm.network.BooksRepository;

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
        mCategoryList.add(new PopularCategory("thriller"));

        mMainView = findViewById(R.id.mainRecyclerView);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mMainView.setLayoutManager(manager);

        MainActivityViewModel model = new ViewModelProvider(this, new MainActivityViewModelFactory(BooksRepository.getInstance())).get(MainActivityViewModel.class);

        model.getVolumes(mCategoryList).observe(this, new Observer<List<List<VolumeInfo>>>() {
            @Override
            public void onChanged(@Nullable List<List<VolumeInfo>> volumeList) {
                int i = 0;
                for(PopularCategory p : mCategoryList) {
                    p.setList(volumeList.get(i));
                    i++;
                }
                mCategoryAdapter = new PopularCategoryAdapter(mCategoryList, MainActivity.this);
                mMainView.setAdapter(mCategoryAdapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        SearchView search = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, BookSearchActivity.class)));
        search.setQueryHint(getResources().getString(R.string.search_hint));
        search.setIconifiedByDefault(false);
        search.setIconified(false);
        return true;
    }
}