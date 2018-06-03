package com.example.koncia.footballapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.koncia.footballapplication.R;
import com.example.koncia.footballapplication.adapters.MenuAdapter;
import com.example.koncia.footballapplication.api.LeaguesApi;
import com.example.koncia.footballapplication.intefaces.MenuContract;
import com.example.koncia.footballapplication.models.League;
import com.example.koncia.footballapplication.presenters.MenuPresenter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuActivity extends AppCompatActivity implements MenuContract.View{

    @BindView(R.id.menu_recycler)
    RecyclerView recyclerView;

    private MenuAdapter menuAdapter;
    private MenuContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LeaguesApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        presenter = new MenuPresenter(this, retrofit.create(LeaguesApi.class));

        menuAdapter = new MenuAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(menuAdapter);
        presenter.getLeagues();
        Log.d("Count", String.valueOf(menuAdapter.getItemCount()));
    }

    @Override
    public void showData(List<League> leagues) {
        menuAdapter.updateLeagues(leagues);
    }
}
