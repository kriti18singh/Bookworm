package com.bookworm;

import com.bookworm.network.BooksRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {

    BooksRepository mRepo;

    public MainActivityViewModelFactory(BooksRepository param) {
        mRepo = param;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(mRepo);
    }
}
