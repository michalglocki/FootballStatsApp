package com.example.koncia.footballapplication.dagger;

import com.example.koncia.footballapplication.api.Api;
import com.example.koncia.footballapplication.intefaces.MenuContract;
import com.example.koncia.footballapplication.models.League;
import com.example.koncia.footballapplication.presenters.MenuPresenter;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MenuModule {
    private MenuContract.View view;

    public MenuModule(MenuContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
    MenuContract.Presenter provideMenuPresenter(Api api, List<League> leagues){
        return new MenuPresenter(view, api, leagues);
    }

}
