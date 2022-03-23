package com.bookworm.network;

import android.annotation.SuppressLint;
import android.util.Log;

import com.bookworm.model.PopularCategory;
import com.bookworm.model.Result;
import com.bookworm.model.VolumeInfo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BooksRepository {

    private Api mApi;

    interface RepositoryCallback<T> {
        void onComplete(List<List<VolumeInfo>> list);
    }

    private static final String TAG = BooksRepository.class.getSimpleName();

    private final String API_KEY = "";

    private BooksRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mApi = retrofit.create(Api.class);
    }

    private static BooksRepository sInstance;

    public static BooksRepository getInstance() {
        if (sInstance == null) {
            sInstance = new BooksRepository();
        }
        return sInstance;
    }

    @SuppressLint("CheckResult")
    public void makeRequest(final List<PopularCategory> queries, final RepositoryCallback callback) {

        String preUrl = "books/v1/volumes?q=subject:";
        Observable<Result> observable1 = mApi.getVolumes(preUrl+queries.get(0).getCategory(), API_KEY, 40);
        Observable<Result> observable2 = mApi.getVolumes(preUrl+queries.get(1).getCategory(), API_KEY, 15);
        Observable<Result> observable3 = mApi.getVolumes(preUrl+queries.get(2).getCategory(), API_KEY, 40);

        Observable<List<List<VolumeInfo>>> result =
                Observable.zip(
                        observable1.subscribeOn(Schedulers.io()),
                        observable2.subscribeOn(Schedulers.io()),
                        observable3.subscribeOn(Schedulers.io()),
                        new Function3<Result, Result, Result, List<List<VolumeInfo>>>() {
                            @Override
                            public List<List<VolumeInfo>> apply(Result result, Result result2, Result result3) throws Exception {
                                List<List<VolumeInfo>> r = new ArrayList<>();
                                r.add(result.getVolumes());
                                r.add(result2.getVolumes());
                                r.add(result3.getVolumes());
                                return r;
                            }
                        }
                );
        result.observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<List<List<VolumeInfo>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<List<VolumeInfo>> lists) {
                        Log.d("KRITI onNext", lists.toString());
                        callback.onComplete(lists);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage());
                    }

                    @SuppressLint("CheckResult")
                    @Override
                    public void onComplete() {
                        Log.d("KRITI", " onComplete");
                    }
                });

    }
}
