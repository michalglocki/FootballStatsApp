package com.example.koncia.footballapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.koncia.footballapplication.FootballApp;
import com.example.koncia.footballapplication.R;
import com.example.koncia.footballapplication.adapters.MenuAdapter;
import com.example.koncia.footballapplication.adapters.TeamsAdapter;
import com.example.koncia.footballapplication.dagger.TeamsModule;
import com.example.koncia.footballapplication.intefaces.TeamsContract;
import com.example.koncia.footballapplication.models.Team;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsActivity extends AppCompatActivity implements TeamsContract.View{

    @Inject
    TeamsContract.Presenter presenter;

    private TeamsAdapter adapter;

    @BindView(R.id.teams_recycler)
    RecyclerView teamsRecycler;

    @BindView(R.id.teams_league_title)
    TextView leagueTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        ButterKnife.bind(this);

        ((FootballApp) getApplication())
                .getAppComponent()
                .plus(new TeamsModule(this))
                .inject(this);

        Intent intent = getIntent();
        adapter = new TeamsAdapter();

        presenter.loadSelectedTeamsToTheView(intent.getIntExtra(MenuAdapter.TEAM_ID,0), adapter);

        teamsRecycler.setLayoutManager(new LinearLayoutManager(this));
        teamsRecycler.setAdapter(adapter);



    }

    @Override
    public void setViewOfTeamsFromSelectedLeague(List<Team> teams) {
        adapter.loadTeams(teams);
    }

    @Override
    public void setLeagueName(String name) {
        leagueTitle.setText(name);
    }
}
