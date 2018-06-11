package com.example.koncia.footballapplication;

import android.app.Application;

import com.example.koncia.footballapplication.dagger.AppComponent;
import com.example.koncia.footballapplication.dagger.AppModule;
import com.example.koncia.footballapplication.dagger.DaggerAppComponent;
import com.example.koncia.footballapplication.dagger.DataModule;

public class FootballApp extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .build();
    }
}
