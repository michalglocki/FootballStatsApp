package com.example.koncia.footballapplication.intefaces;

import com.example.koncia.footballapplication.models.League;

import java.util.List;

public interface MenuContract {

    interface View{

        void showData(List<League> leagues);
    }

    interface Presenter{
        void setLeaguesToView();
    }
}
