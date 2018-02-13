package com.croco.giphy_test;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiphyApi {

    @GET("/v1/gifs/trending")
    Single<TrendingAnswer> trending(@Query("api_key") String apiKey);
}
