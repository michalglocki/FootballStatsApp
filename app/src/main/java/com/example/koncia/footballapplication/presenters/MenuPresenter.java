package com.example.koncia.footballapplication.presenters;


import com.example.koncia.footballapplication.api.LeaguesApi;
import com.example.koncia.footballapplication.intefaces.MenuContract;
import com.example.koncia.footballapplication.models.League;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MenuPresenter implements MenuContract.Presenter {

    @Inject
    LeaguesApi api;
    private MenuContract.View view;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public MenuPresenter(MenuContract.View view, LeaguesApi leaguesApi) {
        this.view = view;
        this.api = leaguesApi;
    }

    @Override
    public void getLeagues() {
        compositeDisposable.add(
                api.getLeagues()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                leagues -> view.showData(leagues),
                                Throwable::printStackTrace
                        )
        );
    }
}
