package com.example.koncia.footballapplication.dagger;

import com.example.koncia.footballapplication.api.Api;
import com.example.koncia.footballapplication.models.League;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    @Provides
    @AppScope
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @AppScope
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @Provides
    @AppScope
    List<League> provideLeaguesList(Api api){
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        List<League> leaguesList = new ArrayList<League>();

        compositeDisposable.add(
                api.getLeagues()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                leagues -> leaguesList.addAll(leagues),
                                Throwable::printStackTrace
                        )
        );
        return leaguesList;
    }
}
