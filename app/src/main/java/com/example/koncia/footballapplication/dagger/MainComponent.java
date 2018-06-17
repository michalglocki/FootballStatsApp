package com.example.koncia.footballapplication.dagger;

import com.example.koncia.footballapplication.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
