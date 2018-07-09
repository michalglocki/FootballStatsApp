package com.example.koncia.footballapplication.models;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ResponseOfSquad {

    private int count;

    @Expose
    private List<Player> players;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
