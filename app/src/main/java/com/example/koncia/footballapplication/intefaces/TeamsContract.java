package com.example.koncia.footballapplication.intefaces;

import com.example.koncia.footballapplication.adapters.TeamsAdapter;
import com.example.koncia.footballapplication.models.Team;

import java.util.List;

public interface TeamsContract {

    interface View{
        void setViewOfTeamsFromSelectedLeague(List<Team> teams);
        void setLeagueName(String name);
    }

    interface Presenter{

        void loadSelectedTeamsToTheView(int id, TeamsAdapter adapter);

        void loadTitle(int teamId);
    }
}
