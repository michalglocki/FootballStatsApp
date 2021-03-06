package com.example.koncia.footballapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.koncia.footballapplication.FootballApp;
import com.example.koncia.footballapplication.R;
import com.example.koncia.footballapplication.adapters.MenuAdapter;
import com.example.koncia.footballapplication.dagger.MenuModule;
import com.example.koncia.footballapplication.intefaces.MenuContract;
import com.example.koncia.footballapplication.models.League;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity implements MenuContract.View{

    @BindView(R.id.menu_recycler)
    RecyclerView recyclerView;

    private MenuAdapter menuAdapter;

    @Inject
    MenuContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        ((FootballApp) getApplication())
                .getAppComponent()
                .plus(new MenuModule(this))
                .inject(this);

        menuAdapter = new MenuAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(menuAdapter);
        presenter.setLeaguesToView();
        Log.d("Count", String.valueOf(menuAdapter.getItemCount()));
    }

    @Override
    public void showData(List<League> leagues) {
        menuAdapter.updateLeagues(leagues);
    }
}
