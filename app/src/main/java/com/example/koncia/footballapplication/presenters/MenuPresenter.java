package com.example.koncia.footballapplication.presenters;


import com.example.koncia.footballapplication.api.Api;
import com.example.koncia.footballapplication.intefaces.MenuContract;
import com.example.koncia.footballapplication.models.League;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MenuPresenter implements MenuContract.Presenter {

    @Inject
    Api api;

    private MenuContract.View view;
    private List<League> leagues;

//    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public MenuPresenter(MenuContract.View view, Api api, List<League> leagues) {
        this.view = view;
        this.api = api;
        this.leagues = leagues;
    }

//    @Override
//    public void getLeagues() {
//        compositeDisposable.add(
//                api.getLeagues()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(
//                                leagues -> view.showData(leagues),
//                                Throwable::printStackTrace
//                        )
//        );
//    }

    @Override
    public void setLeaguesToView() {
        view.showData(leagues);
    }
}
