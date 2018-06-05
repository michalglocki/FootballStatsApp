package com.example.koncia.footballapplication.dagger;

import com.example.koncia.footballapplication.activities.MenuActivity;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {MenuModule.class})
public interface MenuComponent {
    void inject(MenuActivity menuActivity);
}
