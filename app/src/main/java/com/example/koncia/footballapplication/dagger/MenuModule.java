package com.example.koncia.footballapplication.dagger;

import com.example.koncia.footballapplication.api.LeaguesApi;
import com.example.koncia.footballapplication.intefaces.MenuContract;
import com.example.koncia.footballapplication.presenters.MenuPresenter;

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
    MenuContract.Presenter provideMenuPresenter(LeaguesApi api){
        return new MenuPresenter(view, api);
    }
}
