package com.bookworm;

import android.util.Log;

import com.bookworm.model.Result;
import com.bookworm.model.VolumeInfo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityViewModel extends ViewModel {
    public static final String TAG = MainActivityViewModel.class.getSimpleName();

    private String API_KEY = "";

    private MutableLiveData<List<VolumeInfo>> mList;

    public LiveData<List<VolumeInfo>> getVolumes() {
        if (mList == null) {
            mList = new MutableLiveData<>();
            loadVolumes();
        }

        return mList;
    }

    private void loadVolumes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<Result> call = api.getVolumes("potter", API_KEY);


        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result r = response.body();
                Log.d(TAG, response.body().toString());
                mList.setValue(r.getVolumes());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }
}
