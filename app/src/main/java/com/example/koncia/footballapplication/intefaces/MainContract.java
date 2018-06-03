package com.example.koncia.footballapplication.intefaces;

import android.content.Context;

import com.example.koncia.footballapplication.activities.MainActivity;

public interface MainContract {

    interface View{

        void upgradeProgresBar(int progress);

        void goToTheMenuActivity();
    }

    interface Presenter{

        String getUrlForStartingScreen(Context context);

        void updateProgresValue(int progresMaximum) throws InterruptedException;

    }
}
