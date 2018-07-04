package com.example.koncia.footballapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseFromServer {

    private int matchdaay;
    private String leagueCaption;

    @Expose
    private List<Team> standing;

    public int getMatchdaay() {
        return matchdaay;
    }

    public void setCount(int count) {
        this.matchdaay = matchdaay;
    }

    public void setMatchdaay(int matchdaay) {
        this.matchdaay = matchdaay;
    }

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }

    public List<Team> getStanding() {
        return standing;
    }

    public void setStanding(List<Team> standing) {
        this.standing = standing;
    }

    public List<Team> getTeams() {
        return standing;
    }
}
