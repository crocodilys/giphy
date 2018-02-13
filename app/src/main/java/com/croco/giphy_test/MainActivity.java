package com.croco.giphy_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private GiphyApiFacade giphyApiFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giphyApiFacade = new GiphyApiFacade();
        giphyApiFacade.trending().subscribe(new SingleObserver<TrendingAnswer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(TrendingAnswer trendingAnswer) {
                Timber.d("success", trendingAnswer.data);
            }

            @Override
            public void onError(Throwable e) {
                Timber.d(e);
            }
        });
    }
}
