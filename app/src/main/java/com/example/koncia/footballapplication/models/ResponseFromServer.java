package com.example.koncia.footballapplication.models;

public class ResponseFromServer {

    private int count;
    private Team[] teams;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }
}
