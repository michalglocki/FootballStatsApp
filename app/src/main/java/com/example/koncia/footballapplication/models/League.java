package com.example.koncia.footballapplication.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class League {

    private int id;
    @SerializedName("caption")
    private String leagueName;

    @SerializedName("numberOfMatchdays")
    private int matchDays;

    @SerializedName("numberOfTeams")
    private int numberOfTeams;

    @SerializedName("lastUpdated")
    private Date lastUpdated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getMatchDays() {
        return matchDays;
    }

    public void setMatchDays(int matchDays) {
        this.matchDays = matchDays;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
