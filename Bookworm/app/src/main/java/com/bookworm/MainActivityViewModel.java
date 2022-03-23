package com.bookworm;

import com.bookworm.model.PopularCategory;
import com.bookworm.model.VolumeInfo;
import com.bookworm.network.BooksRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel implements BooksRepository.RepositoryCallback {
    private MutableLiveData<List<List<VolumeInfo>>> mList;

    private BooksRepository mRepo;

    public MainActivityViewModel() {}

    public MainActivityViewModel(BooksRepository mRepo) {
        this.mRepo = mRepo;
    }

    public LiveData<List<List<VolumeInfo>>> getVolumes(List<PopularCategory> queryList) {
        if (mList == null) {
            mList = new MutableLiveData<>();
            loadVolumes(queryList);
        }
        return mList;
    }

    private void loadVolumes(List<PopularCategory> query) {
        mRepo.makeRequest(query, this);
    }

    @Override
    public void onComplete(List list) {
        mList.setValue(list);
    }
}
