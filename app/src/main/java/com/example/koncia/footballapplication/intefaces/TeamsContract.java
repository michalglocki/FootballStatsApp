package com.example.koncia.footballapplication.intefaces;

import com.example.koncia.footballapplication.models.Team;

import java.util.List;

public interface TeamsContract {

    interface View{
        void setViewOfTeamsFromSelectedLeague(Team[] teams);
        void setLeagueName(String name);
    }

    interface Presenter{

        void loadSelectedTeamsToTheView(int id);

        void loadTitle(int teamId);
    }
}
