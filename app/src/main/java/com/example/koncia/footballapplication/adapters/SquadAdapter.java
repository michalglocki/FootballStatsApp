package com.example.koncia.footballapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.koncia.footballapplication.R;
import com.example.koncia.footballapplication.models.Player;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SquadAdapter extends RecyclerView.Adapter<SquadAdapter.SquadViewHolder> {

    private List<Player> squad = new ArrayList<>();

    public List<Player> getSquad() {
        return squad;
    }

    @NonNull
    @Override
    public SquadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SquadViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_squad, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull SquadViewHolder holder, int position) {
        holder.setup(squad.get(position));
    }

    @Override
    public int getItemCount() {
        return squad.size();
    }

    class SquadViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.squad_number)
                TextView number;

        @BindView(R.id.squad_name)
        TextView name;

        @BindView(R.id.squad_position)
                TextView position;

        @BindView(R.id.squad_nationality)
                TextView nationality;

        SquadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setup(Player player){
            number.setText(String.valueOf(player.getJerseyNumber()));
            name.setText(player.getName());
            position.setText(player.getPosition());
            nationality.setText(player.getNationality());
        }
    }
}
