package com.example.koncia.footballapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseFromServer {

    private int count;

    @SerializedName("teams")
    @Expose
    private List<Team> teamsList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Team> getTeams() {
        return teamsList;
    }
}
