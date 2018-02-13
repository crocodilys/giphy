package com.croco.giphy_test;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class GiphyApiFacade {

    private static final String GIPHY_API_KEY = "yULMAVYLStYu2hUU1nWhwjJm7QlWjsRq";
    private static final String GIPHY_HOST = "https://api.giphy.com";

    private final GiphyApi giphyApi;

    public GiphyApiFacade() {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(MoshiConverterFactory.create());
        giphyApi = retrofitBuilder.baseUrl(GIPHY_HOST).build().create(GiphyApi.class);
    }

    public Single<TrendingAnswer> trending() {
        return giphyApi.trending(GIPHY_API_KEY);
    }
}
