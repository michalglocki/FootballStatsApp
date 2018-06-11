package com.example.koncia.footballapplication.dagger;

import dagger.Component;

@AppScope
@Component (modules = {AppModule.class, DataModule.class})
public interface AppComponent {
    MenuComponent plus(MenuModule menuModule);
}
