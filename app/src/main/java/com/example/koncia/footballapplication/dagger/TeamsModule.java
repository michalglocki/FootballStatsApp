package com.example.koncia.footballapplication.dagger;

import com.example.koncia.footballapplication.api.Api;
import com.example.koncia.footballapplication.intefaces.TeamsContract;
import com.example.koncia.footballapplication.presenters.TeamsPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TeamsModule {

    private TeamsContract.View view;

    public TeamsModule(TeamsContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    TeamsContract.Presenter provideTeamsPresenter(Api api){
        return new TeamsPresenter(view, api);
    }
}
