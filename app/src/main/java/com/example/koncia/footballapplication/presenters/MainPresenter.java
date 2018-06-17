package com.example.koncia.footballapplication.presenters;

import android.content.Context;
import android.os.AsyncTask;

import com.example.koncia.footballapplication.R;
import com.example.koncia.footballapplication.api.Api;
import com.example.koncia.footballapplication.intefaces.MainContract;
import com.example.koncia.footballapplication.models.League;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private List<League> leagues;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    Api api;

    public MainPresenter(MainContract.View view, Api api, List<League> leagues) {
        this.view = view;
        this.leagues = leagues;
        this.api = api;
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

    @Override
    public void getLeagues() {
        compositeDisposable.add(
                api.getLeagues()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
        );
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



