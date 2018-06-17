package com.example.koncia.footballapplication.dagger;

import com.example.koncia.footballapplication.api.Api;
import com.example.koncia.footballapplication.intefaces.MainContract;
import com.example.koncia.footballapplication.models.League;
import com.example.koncia.footballapplication.presenters.MainPresenter;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    MainContract.Presenter provideMainPresenter(List<League> leagues, Api api){
        return new MainPresenter(view, api, leagues);
    }
}
