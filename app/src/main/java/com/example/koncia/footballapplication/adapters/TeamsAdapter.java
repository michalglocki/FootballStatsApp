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

        @BindView(R.id.item_team_logo)
        ImageView logo;

        @BindView((R.id.item_team_title))
        TextView title;

        @BindView(R.id.item_team_details)
        TextView details;

        @BindView(R.id.team_check_box)
        CheckBox favourite;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void setup(Team team){
            Glide.with(itemView.getContext())
                    .load(team.getLogoUrl())
                    .into(logo);

            title.setText(team.getName());
            details.setText(team.getCode());
        }
    }
}
