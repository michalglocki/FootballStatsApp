package com.example.koncia.footballapplication.presenters;

import android.content.Context;
import android.os.AsyncTask;

import com.example.koncia.footballapplication.R;
import com.example.koncia.footballapplication.intefaces.MainContract;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public String getUrlForStartingScreen(Context context) {
        return context.getResources().getString(R.string.url_main_activity);
    }

    @Override
    public void updateProgresValue(int progresMax) throws InterruptedException {
        //todo it require cover with RxJava od AsyncTask to do the counting on the other thread
        new CountingOperation().execute(String.valueOf(progresMax));
    }


    private class CountingOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            int progresBarSize = Integer.parseInt(params[0]);
            for (int i = 0; i < progresBarSize; i++) {
                try {
                    Thread.sleep(1000);
                    view.upgradeProgresBar(i);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            view.goToTheMenuActivity();
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}



