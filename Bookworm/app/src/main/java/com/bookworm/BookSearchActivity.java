package com.bookworm;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import com.bookworm.databinding.ActivityBookSearchBinding;

public class BookSearchActivity extends AppCompatActivity {

    private ActivityBookSearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBookSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Intent.ACTION_SEARCH.equals(getIntent().getAction())) {
            String query = getIntent().getStringExtra(SearchManager.QUERY);
            Log.d("KRITI query = ", query);
        }
    }
}