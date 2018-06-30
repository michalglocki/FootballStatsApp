package com.example.koncia.footballapplication.presenters;

import com.example.koncia.footballapplication.adapters.TeamsAdapter;
import com.example.koncia.footballapplication.api.Api;
import com.example.koncia.footballapplication.intefaces.TeamsContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class TeamsPresenter implements TeamsContract.Presenter{

    private Api api;
    private TeamsContract.View view;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public TeamsPresenter(TeamsContract.View view, Api api) {
        this.api = api;
        this.view = view;
    }

    @Override
    public void loadSelectedTeamsToTheView(int id, TeamsAdapter adapter) {

        compositeDisposable.add(
                api.getResponseFromServer(String.valueOf(id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        responseFromServer -> view.setViewOfTeamsFromSelectedLeague(responseFromServer.getTeams())
                )
        );
    }

    @Override
    public void loadTitle(int teamId) {

    }

}
