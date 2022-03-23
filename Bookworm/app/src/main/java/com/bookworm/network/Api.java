package com.bookworm.network;

import com.bookworm.model.Result;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {

    String BASE_URL = "https://www.googleapis.com/";

    @GET
    Observable<Result> getVolumes(@Url String url, @Query("key") String api_key, @Query("maxResults") int max);
}
