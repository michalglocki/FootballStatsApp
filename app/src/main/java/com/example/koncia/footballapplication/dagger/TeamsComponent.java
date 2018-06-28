package com.example.koncia.footballapplication.dagger;

import com.example.koncia.footballapplication.activities.TeamsActivity;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {TeamsModule.class})
public interface TeamsComponent {

    void inject(TeamsActivity teamsActivity);
}
