package com.bookworm;

import com.bookworm.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://www.googleapis.com/";

    @GET("books/v1/volumes")
    Call<Result> getVolumes(@Query(value= "q",encoded = true) String q, @Query("key") String api_key);
}
