package com.example.koncia.footballapplication.api;

import com.example.koncia.footballapplication.models.League;
import com.example.koncia.footballapplication.models.ResponseFromServer;
import com.example.koncia.footballapplication.models.Team;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface Api {
    String BASE_URL = "http://api.football-data.org/v1/";

    @Headers("X-Auth-Token: f3b4f6f151054f69842c2c502b6a560d")
    @GET("soccerseasons")
    Single<List<League>> getLeagues();

    @Headers("X-Auth-Token: f3b4f6f151054f69842c2c502b6a560d")
    @GET("competitions/{id}/teams")
    Single<ResponseFromServer> getResponseFromServer(@Path("id") String id);
}
