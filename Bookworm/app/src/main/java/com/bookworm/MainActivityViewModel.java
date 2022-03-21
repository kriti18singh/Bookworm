package com.bookworm;

import android.util.Log;

import com.bookworm.model.Result;
import com.bookworm.model.VolumeInfo;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityViewModel extends ViewModel {

    private String API_KEY = "";

    private MutableLiveData<List<VolumeInfo>> mList;

    //we will call this method to get the data
    public LiveData<List<VolumeInfo>> getVolumes() {
        //if the list is null
        if (mList == null) {
            mList = new MutableLiveData<List<VolumeInfo>>();
            //we will load it asynchronously from server in this method
            loadVolumes();
        }

        //finally we will return the list
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

                //finally we are setting the list to our MutableLiveData

                Result r = response.body();
                mList.setValue(r.getVolumes());
                Log.d("KRITI response = ", response.body().toString());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("KRITI onFailure", t.getMessage());
            }
        });
    }
}
