package com.example.koncia.footballapplication.dagger;

import com.example.koncia.footballapplication.activities.MainActivity;

import dagger.Component;

@AppScope
@Component (modules = {AppModule.class, DataModule.class})
public interface AppComponent {
    MenuComponent plus(MenuModule menuModule);
    MainComponent plus(MainModule mainModule);
    TeamsComponent plus(TeamsModule teamsModule);

}
