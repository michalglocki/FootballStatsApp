package com.example.koncia.footballapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.koncia.footballapplication.R;
import com.example.koncia.footballapplication.models.Team;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder>{

    private Team[] teams = new Team[1];

    public void loadTeams(Team[] teams){
        this.teams = teams;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setup(teams[position]);
    }

    @Override
    public int getItemCount() {
        return teams.length;
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

        public ViewHolder(View itemView) {
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
