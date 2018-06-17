package com.example.koncia.footballapplication.api;

import com.example.koncia.footballapplication.models.League;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "http://api.football-data.org/v1/";

    @GET("soccerseasons")
    Single<List<League>> getLeagues();
}
