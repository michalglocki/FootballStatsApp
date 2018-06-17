package com.example.koncia.footballapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.koncia.footballapplication.R;
import com.example.koncia.footballapplication.activities.TeamsActivity;
import com.example.koncia.footballapplication.models.League;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    @Inject List<League> leaguesList;

    public static final String TEAM_ID = "teamID";


    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leagues, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.setup(leaguesList.get(position));
    }

    @Override
    public int getItemCount() {
        return leaguesList.size();
    }

    public void updateLeagues(List<League> leagues) {
        leaguesList = leagues;
        //leaguesList.addAll(leagues);
        notifyDataSetChanged();
        Log.d("Count", String.valueOf(leaguesList.size()));
    }

    class MenuViewHolder extends RecyclerView.ViewHolder{

        private League thisLeague;

        @BindView(R.id.league_name)
        TextView nameTextView;

        @BindView(R.id.league_match_days)
        TextView matchDaysTextView;

        @BindView(R.id.league_teams_count)
        TextView teamsCountTextView;

        @OnClick(R.id.leagues_constraint_layout)
        void goToTheExactLeague(){
            Context context = nameTextView.getContext();
            Intent intent = new Intent(context, TeamsActivity.class);
            intent.putExtra(TEAM_ID, thisLeague.getId());
            context.startActivity(intent);
        }

        public MenuViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setup(League league) {
            thisLeague = league;
            nameTextView.setText(league.getLeagueName());
            matchDaysTextView.setText(new StringBuilder().append("Match Days: ").append(league.getMatchDays()).toString());
            teamsCountTextView.setText(new StringBuilder().append("Numer of teams: ").append(league.getNumberOfTeams()).toString());
        }
    }
}
