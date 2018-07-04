package com.example.koncia.footballapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.koncia.footballapplication.R;
import com.example.koncia.footballapplication.models.Team;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder>{

    private List<Team> teams = new ArrayList<>();

    public void loadTeams(List<Team> teams){
        this.teams = teams;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TeamsAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setup(teams.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d("count", String.valueOf(teams.size()));
        return teams.size();
    }

    public List<Team> getTeams() {
        return teams;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView((R.id.item_team_title))
        TextView title;

        @BindView(R.id.item_team_position)
        TextView position;

        @BindView(R.id.item_team_points)
        TextView points;

        @BindView(R.id.item_team_goals)
        TextView goals;

        @BindView(R.id.item_team_wins)
        TextView wins;

        @BindView(R.id.item_team_draws)
        TextView draws;

        @BindView(R.id.item_team_losses)
        TextView losses;

        @BindView(R.id.team_check_box)
        CheckBox favourite;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void setup(Team team){

            title.setText(team.getName());
            position.setText(String.valueOf(team.getPosition()));
            points.setText(String.valueOf(team.getPoints()));
            goals.setText(String.valueOf(team.getGoals()));
            wins.setText(String.valueOf(team.getWins()));
            draws.setText(String.valueOf(team.getDraws()));
            losses.setText(String.valueOf(team.getLosses()));
        }
    }
}
